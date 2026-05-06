"""Recompute every numerical claim in paper-trim-B.tex against raw data.

For each claim, print: claim text -> recomputed value -> match? (or note).
"""
from __future__ import annotations

import sys
from itertools import combinations
from pathlib import Path

import numpy as np
import pandas as pd
from scipy import stats

sys.path.insert(0, str(Path(__file__).parent))
from regen_figures import load_long, participant_collapse  # noqa: E402


def fisher_z_p(r1: float, n1: int, r2: float, n2: int) -> float:
    """Two-tailed p-value for difference between two Spearman correlations."""
    z1 = np.arctanh(r1)
    z2 = np.arctanh(r2)
    se = np.sqrt(1 / (n1 - 3) + 1 / (n2 - 3))
    z = (z1 - z2) / se
    return 2 * (1 - stats.norm.cdf(abs(z)))


def show(claim: str, paper: str, recomputed, match: bool | str):
    flag = "OK" if match is True else ("FLAG" if match is False else str(match))
    print(f"[{flag:4}] {claim}")
    print(f"        paper: {paper}")
    print(f"   recomputed: {recomputed}")
    print()


def normalize_pid(s: str) -> str:
    """Reduce participant labels to a stable key like 'p06', 'p13'.
    Handles 'P06 metal DFS', 'P10- metal DFS correct', 'P13metalBFS', etc."""
    import re
    t = str(s).lower()
    t = re.sub(r"[\s\-_]+", "", t)
    for tok in ("correct", "metal", "galles", "dfs", "bfs"):
        t = t.replace(tok, "")
    return t


def main():
    df = load_long()
    df["pid"] = df["participant"].map(normalize_pid)
    print("=" * 78)
    print("RAW DATA SHAPE AFTER LOAD")
    print("=" * 78)
    print(f"Rows: {len(df)}  (paper claims 117)")
    print(df.groupby(["group", "algorithm"]).size().unstack().to_string())
    print(f"\nUnique participants per group (using normalized pid):")
    for g in (1, 2, 3):
        ids = set(df[df.group == g].pid)
        print(f"  G{g}: {len(ids)} unique  (paper claims G1=19, G2=21, G3=20)")
    print()
    print("Sample normalization (per algo, group 1):")
    for algo in ("BFS", "DFS"):
        sub = df[(df.group == 1) & (df.algorithm == algo)][["participant", "pid"]]
        print(f"  G1 {algo} pids: {sorted(set(sub.pid))[:6]} ... ({len(set(sub.pid))} total)")
    print()

    # Combined: collapse BFS+DFS per normalized participant
    num_cols = df.select_dtypes("number").columns.tolist()
    combined = (
        df.groupby(["pid", "group"], as_index=False)[num_cols].mean()
    )
    dfs_only = df[df.algorithm == "DFS"].copy()
    dfs_only = dfs_only.groupby(["pid", "group"], as_index=False)[num_cols].mean()

    print("=" * 78)
    print("§4.2 TFD CORRELATIONS  (paper reports combined BFS+DFS, per participant)")
    print("=" * 78)
    paper_tfd = {1: ("-.034", "NS", 19), 2: ("-.457", "p<.050", 21), 3: ("-.631", "p=.003", 20)}
    rho_tfd = {}
    for g in (1, 2, 3):
        d = combined[combined.group == g]
        rho, p = stats.spearmanr(d.tfd_pseudo, d.tfd_map)
        rho_tfd[g] = (rho, p, len(d))
        show(
            f"TFD ρ(G{g})",
            f"{paper_tfd[g][0]} {paper_tfd[g][1]} n={paper_tfd[g][2]}",
            f"{rho:+.3f} p={p:.4f} n={len(d)}",
            None,
        )

    print("=" * 78)
    print("§4.2 FISHER Z ON TFD")
    print("=" * 78)
    paper_z = {(1, 3): "p<.050", (1, 2): "p=.180", (2, 3): "p=.470"}
    for (a, b), exp in paper_z.items():
        r1, _, n1 = rho_tfd[a]
        r2, _, n2 = rho_tfd[b]
        p = fisher_z_p(r1, n1, r2, n2)
        show(f"Fisher z TFD G{a} vs G{b}", exp, f"p={p:.3f}", None)

    print("=" * 78)
    print("§4.2 FC CORRELATIONS")
    print("=" * 78)
    paper_fc = {1: "+.042 NS", 2: "+.326 NS", 3: "-.161 NS"}
    rho_fc = {}
    for g in (1, 2, 3):
        d = combined[combined.group == g]
        rho, p = stats.spearmanr(d.fc_pseudo, d.fc_map)
        rho_fc[g] = (rho, p, len(d))
        show(f"FC ρ(G{g})", paper_fc[g], f"{rho:+.3f} p={p:.4f}", None)

    print("=" * 78)
    print("§4.2 FISHER Z ON FC")
    print("=" * 78)
    paper_z_fc = {(2, 3): "p=.130", (1, 3): "p=.550", (1, 2): "p=.380"}
    for (a, b), exp in paper_z_fc.items():
        r1, _, n1 = rho_fc[a]
        r2, _, n2 = rho_fc[b]
        p = fisher_z_p(r1, n1, r2, n2)
        show(f"Fisher z FC G{a} vs G{b}", exp, f"p={p:.3f}", None)

    print("=" * 78)
    print("§4.1 INVERTED-U MEDIANS  (combined BFS+DFS)")
    print("=" * 78)
    paper_med = {1: 9.57, 2: 12.33, 3: 6.12}
    for g in (1, 2, 3):
        med = combined[combined.group == g].ratio.median()
        show(f"median ratio G{g}", f"{paper_med[g]}", f"{med:.3f}", None)

    print("=" * 78)
    print("§4.1 BFS vs DFS RATIO TEST  (paper claim: G1 differs p=.040, G2/G3 p>.50)")
    print("=" * 78)
    for g in (1, 2, 3):
        bfs = df[(df.group == g) & (df.algorithm == "BFS")].ratio.dropna()
        dfs = df[(df.group == g) & (df.algorithm == "DFS")].ratio.dropna()
        u, p = stats.mannwhitneyu(bfs, dfs, alternative="two-sided")
        wsr = stats.wilcoxon(
            df[(df.group == g) & (df.algorithm == "BFS")]
            .set_index("participant")
            .ratio.combine_first(pd.Series(dtype=float)),
            df[(df.group == g) & (df.algorithm == "DFS")]
            .set_index("participant")
            .ratio.combine_first(pd.Series(dtype=float)),
        ) if False else None  # avoid the paired test path; paper unclear which
        show(
            f"BFS vs DFS ratio G{g} (Mann-Whitney)",
            "G1 p=.040, G2/G3 p>.50" if g == 1 else "expected p>.50" if g in (2, 3) else "",
            f"U p={p:.3f}",
            None,
        )

    print("=" * 78)
    print("§4.1 BFS vs DFS RATIO  (paired Wilcoxon, since within-subject)")
    print("=" * 78)
    for g in (1, 2, 3):
        sub = df[df.group == g].pivot_table(
            index="participant", columns="algorithm", values="ratio"
        ).dropna()
        if len(sub) >= 5:
            stat, p = stats.wilcoxon(sub["BFS"], sub["DFS"])
            show(
                f"Wilcoxon paired BFS vs DFS ratio G{g}",
                "G1 p=.040" if g == 1 else "p>.50" if g in (2, 3) else "",
                f"p={p:.3f}  (n={len(sub)} paired)",
                None,
            )

    print("=" * 78)
    print("§4.3 ALL-PAIR MEAN |ρ| COUPLING  (combined BFS+DFS)")
    print("=" * 78)
    paper_coup = {1: .294, 2: .330, 3: .369}
    keys_all = ["tfd_pseudo", "tfd_map", "fc_pseudo", "fc_map",
                "ratio", "scanner_index", "depth_pseudo", "depth_map",
                "switch_rate", "vc_pseudo", "vc_map",
                "tvd_pseudo", "tvd_map", "ffd_pseudo", "ffd_map"]
    keys_all = [k for k in keys_all if k in combined.columns]
    keys_basic = ["tfd_pseudo", "tfd_map", "fc_pseudo", "fc_map",
                  "ratio", "scanner_index", "depth_pseudo", "switch_rate"]
    for label, keys in (("8-metric", keys_basic), ("all-numeric", keys_all)):
        print(f"\n  Using metric set: {label} ({len(keys)} metrics)")
        for g in (1, 2, 3):
            d = combined[combined.group == g][keys]
            corr = d.corr(method="spearman").abs().to_numpy(copy=True)
            np.fill_diagonal(corr, np.nan)
            mean_abs = np.nanmean(corr)
            print(f"    G{g} mean |ρ| = {mean_abs:.3f}  (paper claims {paper_coup[g]})")

    print("=" * 78)
    print("§4.3 RATIO ↔ SCANNER-INDEX  (paper claim: G1 r=-.04, G3 r=-.67)")
    print("=" * 78)
    for g in (1, 3):
        d = combined[combined.group == g]
        rho, p = stats.spearmanr(d.ratio, d.scanner_index)
        show(
            f"ρ(ratio, scanner_index) G{g}",
            "-.04" if g == 1 else "-.67",
            f"{rho:+.3f} p={p:.3f}",
            None,
        )

    print("=" * 78)
    print("§4.3 DFS-ONLY MEAN |ρ|  (B fig caption: .368 / .483 / .605)")
    print("=" * 78)
    for g in (1, 2, 3):
        d = dfs_only[dfs_only.group == g][keys_basic]
        corr = d.corr(method="spearman").abs().to_numpy(copy=True)
        np.fill_diagonal(corr, np.nan)
        mean_abs = np.nanmean(corr)
        print(f"  G{g} DFS-only mean |ρ| = {mean_abs:.3f}")

    print("=" * 78)
    print("§4.3 'SCANNER INDEX, DEPTH, SWITCH RATE all p>.20'  (DFS-only Kruskal)")
    print("=" * 78)
    for k in ("scanner_index", "depth_pseudo", "switch_rate"):
        groups = [dfs_only[dfs_only.group == g][k].dropna() for g in (1, 2, 3)]
        h, p = stats.kruskal(*groups)
        show(f"Kruskal-Wallis on {k} across G1/G2/G3 (DFS)", "p>.20", f"H={h:.2f} p={p:.3f}", None)

    print("=" * 78)
    print("§5.3 LIMITATIONS '105 Fisher z tests'")
    print("=" * 78)
    # 105 = ?  combinations: 15 metrics choose 2 = 105.  Or 15 × 7 group-comparisons?
    # If 15 metric pairs × 7 group-comparisons = 105.  Or C(15,2)=105 metric pairs (one comparison each).
    candidates = []
    for n in range(5, 25):
        if n * (n - 1) / 2 == 105:
            candidates.append(f"{n} choose 2")
        for k in (3, 6, 7, 9):
            if n * k == 105:
                candidates.append(f"{n} × {k}")
    print(f"  105 factors as: {candidates}")
    print(f"  Likely: C(15,2)=105 metric-pair tests; OR 15 metrics × 7 comparisons.")
    print(f"  Paper does not enumerate. Treat as approximate.")
    print()

    print("=" * 78)
    print("FIG CAPTIONS — DFS-only G3 ρ for TFD")
    print("=" * 78)
    for g in (1, 2, 3):
        d = dfs_only[dfs_only.group == g]
        rho, p = stats.spearmanr(d.tfd_pseudo, d.tfd_map)
        print(f"  DFS-only TFD G{g}: ρ={rho:+.3f} p={p:.4f} n={len(d)}")
    print(
        "  Caption claim: 'G3 ρ=-.66 p=.002; G1 flat'  -> recomputed values above."
    )

    print("\nDONE. Inspect [FLAG] lines (none here — review NOT-OK fields manually).")


if __name__ == "__main__":
    main()
