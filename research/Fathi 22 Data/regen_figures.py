"""Regenerate paper figures from Metal DE eye-tracking data.

Scope: Metal style only, DE stimulus only, DFS-focused with BFS shown for
comparison where the paper's design calls for it. Outputs land in
analysis/overleaf/ so the LaTeX build picks them up directly.

Run from this directory after activating .venv:
    .venv/bin/python regen_figures.py
"""
from __future__ import annotations

from pathlib import Path

import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import seaborn as sns
from scipy import stats

DATA_DIR = Path(__file__).parent
OUT = DATA_DIR / "analysis" / "overleaf"

GROUPS = {
    1: ("G1 (novice)", "#3a7ca5"),
    2: ("G2 (intermediate)", "#d99846"),
    3: ("G3 (advanced)", "#a6453a"),
}

METAL_FILES = [
    (1, "BFS", "Group1_metalBFSData.xls", "DE-bft.wmv"),
    (1, "DFS", "Group1_metalDFSData.xls", "DE-dft.wmv"),
    (2, "BFS", "Group2_metalBFSData.xls", "DE-bft.wmv"),
    (2, "DFS", "Group2_metalDFSData.xls", "DE-dft.wmv"),
    (3, "BFS", "Group3_metalBFSData.xls", "DE-bft.wmv"),
    (3, "DFS", "Group3_metalDFSData.xls", "DE-dft.wmv"),
]


def col(df: pd.DataFrame, metric: str, video: str, aoi: str) -> str | None:
    return next(
        (
            c
            for c in df.columns
            if metric in c
            and video in c
            and aoi in c
            and c.endswith("_Mean")
            and "Include Zeros" not in c
        ),
        None,
    )


def load_long() -> pd.DataFrame:
    rows = []
    for group, algo, fname, video in METAL_FILES:
        df = pd.read_excel(DATA_DIR / fname)
        df = df.rename(columns={df.columns[0]: "participant"})
        df = df[df["participant"].astype(str).str.strip() != "All Recordings"]
        df = df[~df["participant"].astype(str).str.contains("galles", case=False)]
        cols = {
            "tfd_pseudo": col(df, "Total Fixation Duration", video, "Rectangle_"),
            "tfd_map": col(df, "Total Fixation Duration", video, "Rectangle 2_"),
            "fc_pseudo": col(df, "Fixation Count", video, "Rectangle_"),
            "fc_map": col(df, "Fixation Count", video, "Rectangle 2_"),
            "vc_pseudo": col(df, "Visit Count", video, "Rectangle_"),
            "vc_map": col(df, "Visit Count", video, "Rectangle 2_"),
            "tvd_pseudo": col(df, "Total Visit Duration", video, "Rectangle_"),
            "tvd_map": col(df, "Total Visit Duration", video, "Rectangle 2_"),
            "ffd_pseudo": col(df, "First Fixation Duration", video, "Rectangle_"),
            "ffd_map": col(df, "First Fixation Duration", video, "Rectangle 2_"),
            "ttff_pseudo": col(df, "Time to First Fixation", video, "Rectangle_"),
            "ttff_map": col(df, "Time to First Fixation", video, "Rectangle 2_"),
        }
        for _, r in df.iterrows():
            rec = {"group": group, "algorithm": algo, "participant": r["participant"]}
            for k, v in cols.items():
                rec[k] = pd.to_numeric(r[v], errors="coerce") if v is not None else np.nan
            rows.append(rec)
    out = pd.DataFrame(rows)
    out = out.dropna(subset=["tfd_pseudo", "tfd_map"]).copy()
    out["ratio"] = out["tfd_pseudo"] / out["tfd_map"]
    out["scanner_index"] = out["vc_pseudo"] / out["tfd_pseudo"]
    out["depth_pseudo"] = out["tfd_pseudo"] / out["fc_pseudo"]
    out["depth_map"] = out["tfd_map"] / out["fc_map"]
    out["switch_rate"] = (out["vc_pseudo"] + out["vc_map"]) / (
        out["tfd_pseudo"] + out["tfd_map"]
    )
    return out


def participant_collapse(df: pd.DataFrame, algo: str | None = None) -> pd.DataFrame:
    sub = df if algo is None else df[df["algorithm"] == algo]
    num = sub.select_dtypes("number").columns.tolist()
    return (
        sub.groupby(["participant", "group"], as_index=False)[num].mean().assign(
            algorithm=algo or "BOTH"
        )
    )


def style():
    sns.set_theme(style="whitegrid", context="paper", font_scale=1.05)
    plt.rcParams.update({
        "axes.spines.top": False,
        "axes.spines.right": False,
        "savefig.bbox": "tight",
        "savefig.dpi": 200,
    })


# -----------------------------------------------------------------------------
# Figures
# -----------------------------------------------------------------------------

def fig_tfd_substitution(df: pd.DataFrame):
    """Primary result: TFD pseudocode vs TFD map by group, DFS only."""
    sub = participant_collapse(df, "DFS")
    fig, ax = plt.subplots(figsize=(7.0, 4.4))
    for g in (1, 2, 3):
        d = sub[sub.group == g]
        label, color = GROUPS[g]
        rho, p = stats.spearmanr(d["tfd_pseudo"], d["tfd_map"])
        ax.scatter(
            d["tfd_pseudo"],
            d["tfd_map"],
            color=color,
            s=44,
            alpha=0.85,
            edgecolor="white",
            linewidth=0.6,
            label=f"{label}  ρ = {rho:+.2f}, p = {p:.3f}, n = {len(d)}",
        )
        if len(d) >= 3:
            x = np.linspace(d["tfd_pseudo"].min(), d["tfd_pseudo"].max(), 50)
            slope, intercept, *_ = stats.linregress(d["tfd_pseudo"], d["tfd_map"])
            ax.plot(x, slope * x + intercept, color=color, lw=1.4, alpha=0.85)
    ax.set_xlabel("TFD on Pseudocode (s)")
    ax.set_ylabel("TFD on Map (s)")
    ax.set_title("DFS · DE · Metal — Pseudocode/Map TFD substitution by expertise")
    ax.legend(loc="upper right", frameon=True, fontsize=9)
    fig.savefig(OUT / "fig_tfd_substitution_dfs.png")
    plt.close(fig)


def fig_inverted_u_ratio(df: pd.DataFrame):
    """Inverted-U pattern in TFD ratio (Pseudocode/Map) — DFS only."""
    sub = participant_collapse(df, "DFS")
    fig, ax = plt.subplots(figsize=(6.4, 4.0))
    palette = [GROUPS[g][1] for g in (1, 2, 3)]
    sns.boxplot(
        data=sub,
        x="group",
        y="ratio",
        ax=ax,
        hue="group",
        palette=palette,
        legend=False,
        width=0.55,
        fliersize=0,
        linewidth=1.0,
    )
    sns.stripplot(
        data=sub,
        x="group",
        y="ratio",
        ax=ax,
        color="#222",
        alpha=0.55,
        size=3.4,
        jitter=0.18,
    )
    medians = sub.groupby("group")["ratio"].median()
    for i, g in enumerate((1, 2, 3)):
        ax.text(i, medians[g], f"  med = {medians[g]:.2f}", va="center", fontsize=8.5)
    ax.set_xticks(range(3))
    ax.set_xticklabels([GROUPS[g][0] for g in (1, 2, 3)])
    ax.set_xlabel("")
    ax.set_ylabel("TFD$_\\mathrm{pseudo}$ / TFD$_\\mathrm{map}$")
    ax.set_yscale("log")
    ax.set_title("DFS · DE · Metal — inverted-U in pseudocode/map ratio")
    fig.savefig(OUT / "fig_ratio_inverted_u_dfs.png")
    plt.close(fig)


def fig_bfs_vs_dfs(df: pd.DataFrame):
    """Substitution scatter side-by-side: BFS vs DFS, both DE Metal."""
    fig, axes = plt.subplots(1, 2, figsize=(10.4, 4.4), sharex=True, sharey=True)
    for ax, algo in zip(axes, ("BFS", "DFS")):
        sub = participant_collapse(df, algo)
        for g in (1, 2, 3):
            d = sub[sub.group == g]
            label, color = GROUPS[g]
            rho, p = stats.spearmanr(d["tfd_pseudo"], d["tfd_map"])
            ax.scatter(
                d["tfd_pseudo"],
                d["tfd_map"],
                color=color,
                s=38,
                alpha=0.85,
                edgecolor="white",
                linewidth=0.5,
                label=f"{label}: ρ={rho:+.2f}, p={p:.3f}",
            )
            if len(d) >= 3:
                x = np.linspace(d["tfd_pseudo"].min(), d["tfd_pseudo"].max(), 50)
                slope, intercept, *_ = stats.linregress(d["tfd_pseudo"], d["tfd_map"])
                ax.plot(x, slope * x + intercept, color=color, lw=1.3, alpha=0.85)
        ax.set_title(f"{algo} · DE · Metal")
        ax.set_xlabel("TFD on Pseudocode (s)")
        ax.legend(loc="upper right", fontsize=8.2, frameon=True)
    axes[0].set_ylabel("TFD on Map (s)")
    fig.suptitle(
        "DFS reveals the expertise gradient; BFS forces substitution at every expertise level",
        y=1.02,
        fontsize=11.5,
    )
    fig.savefig(OUT / "fig_bfs_vs_dfs_substitution.png")
    plt.close(fig)


KEY_METRICS_FOR_COUPLING = [
    ("tfd_pseudo", "TFD pseudo"),
    ("tfd_map", "TFD map"),
    ("fc_pseudo", "FC pseudo"),
    ("fc_map", "FC map"),
    ("ratio", "ratio"),
    ("scanner_index", "scan idx"),
    ("depth_pseudo", "depth pseudo"),
    ("switch_rate", "switch rate"),
]


def fig_coupling_heatmap(df: pd.DataFrame):
    """|Spearman ρ| heatmaps across key metrics, DFS only, by group."""
    sub = participant_collapse(df, "DFS")
    keys = [k for k, _ in KEY_METRICS_FOR_COUPLING]
    labels = [v for _, v in KEY_METRICS_FOR_COUPLING]
    fig, axes = plt.subplots(1, 3, figsize=(11.6, 3.8))
    means = []
    for ax, g in zip(axes, (1, 2, 3)):
        d = sub[sub.group == g][keys]
        rho = d.corr(method="spearman").abs().to_numpy(copy=True)
        np.fill_diagonal(rho, np.nan)
        rho = pd.DataFrame(rho, index=labels, columns=labels)
        sns.heatmap(
            rho,
            ax=ax,
            cmap="rocket_r",
            vmin=0,
            vmax=1,
            cbar=(g == 3),
            xticklabels=labels,
            yticklabels=labels,
            square=True,
            linewidths=0.4,
            linecolor="white",
            annot=True,
            fmt=".2f",
            annot_kws={"fontsize": 6.5},
        )
        mean_abs = np.nanmean(rho.values)
        ax.set_title(f"{GROUPS[g][0]}   mean |ρ| = {mean_abs:.3f}")
        ax.tick_params(axis="x", labelsize=7.5, rotation=45)
        ax.tick_params(axis="y", labelsize=7.5)
        means.append(mean_abs)
    fig.suptitle(
        "DFS · DE · Metal — attentional coupling grows with expertise (|ρ| matrix)",
        y=1.04,
        fontsize=11.5,
    )
    fig.savefig(OUT / "fig_coupling_heatmap_dfs.png")
    plt.close(fig)
    return means


def fig_metric_battery(df: pd.DataFrame):
    """Six-panel distributions of key metrics — DFS only — by group."""
    sub = participant_collapse(df, "DFS")
    panels = [
        ("tfd_pseudo", "TFD on Pseudocode (s)"),
        ("tfd_map", "TFD on Map (s)"),
        ("ratio", "Pseudocode/Map TFD ratio (log)"),
        ("scanner_index", "Scanner index (visits / s on pseudocode)"),
        ("depth_pseudo", "Avg fixation depth on pseudocode (s)"),
        ("switch_rate", "Switching rate (visits / s)"),
    ]
    fig, axes = plt.subplots(2, 3, figsize=(11.4, 6.4))
    palette = [GROUPS[g][1] for g in (1, 2, 3)]
    for ax, (k, lab) in zip(axes.flat, panels):
        sns.violinplot(
            data=sub,
            x="group",
            y=k,
            ax=ax,
            hue="group",
            palette=palette,
            legend=False,
            inner=None,
            linewidth=0.9,
            cut=0,
        )
        sns.stripplot(
            data=sub,
            x="group",
            y=k,
            ax=ax,
            color="#222",
            alpha=0.5,
            size=2.8,
            jitter=0.16,
        )
        ax.set_xticks(range(3))
        ax.set_xticklabels(["G1", "G2", "G3"])
        ax.set_xlabel("")
        ax.set_ylabel(lab)
        if k == "ratio":
            ax.set_yscale("log")
    fig.suptitle(
        "DFS · DE · Metal — per-participant metric distributions by expertise",
        y=1.0,
        fontsize=12,
    )
    fig.tight_layout()
    fig.savefig(OUT / "fig_metric_battery_dfs.png")
    plt.close(fig)


def fig_correlation_summary(df: pd.DataFrame):
    """Lollipop summary of TFD/FC pseudo-vs-map correlations by group, DFS."""
    sub = participant_collapse(df, "DFS")
    rows = []
    for g in (1, 2, 3):
        d = sub[sub.group == g]
        for label, x, y in (
            ("TFD", "tfd_pseudo", "tfd_map"),
            ("FC", "fc_pseudo", "fc_map"),
        ):
            rho, p = stats.spearmanr(d[x], d[y])
            rows.append({"group": g, "metric": label, "rho": rho, "p": p, "n": len(d)})
    summary = pd.DataFrame(rows)

    fig, ax = plt.subplots(figsize=(7.4, 3.6))
    width = 0.34
    xs = np.arange(3)
    for offset, metric, color in (
        (-width / 2, "TFD", "#2c3e50"),
        (width / 2, "FC", "#aa6f2c"),
    ):
        d = summary[summary.metric == metric].set_index("group").loc[[1, 2, 3]]
        ax.vlines(xs + offset, 0, d["rho"], color=color, lw=2.2, alpha=0.9)
        ax.scatter(
            xs + offset,
            d["rho"],
            s=80,
            color=color,
            zorder=3,
            label=f"{metric} (Spearman ρ)",
        )
        for x_, rho_, p_ in zip(xs + offset, d["rho"], d["p"]):
            sig = "*" if p_ < 0.05 else ""
            ax.text(
                x_,
                rho_ + (0.03 if rho_ >= 0 else -0.07),
                f"{rho_:+.2f}{sig}",
                ha="center",
                fontsize=8.4,
            )
    ax.axhline(0, color="#888", lw=0.7)
    ax.set_xticks(xs)
    ax.set_xticklabels([GROUPS[g][0] for g in (1, 2, 3)])
    ax.set_ylabel("Spearman ρ (pseudo vs. map)")
    ax.set_title(
        "DFS · DE · Metal — TFD substitution monotonic; FC sign-reversal directional"
    )
    ax.legend(loc="lower left", fontsize=9, frameon=True)
    ax.set_ylim(-0.95, 0.6)
    fig.savefig(OUT / "fig_correlation_summary_dfs.png")
    plt.close(fig)
    return summary


def main():
    style()
    OUT.mkdir(parents=True, exist_ok=True)
    df = load_long()
    print(f"Loaded {len(df)} participant-trial rows after dropna.")
    print(df.groupby(["group", "algorithm"]).size().unstack().to_string())
    fig_tfd_substitution(df)
    fig_inverted_u_ratio(df)
    fig_bfs_vs_dfs(df)
    means = fig_coupling_heatmap(df)
    fig_metric_battery(df)
    summary = fig_correlation_summary(df)
    print("\nDFS correlation summary:")
    print(summary.to_string(index=False))
    print(f"\nMean |ρ| (DFS): G1={means[0]:.3f}  G2={means[1]:.3f}  G3={means[2]:.3f}")
    print("\nFigures written to", OUT)


if __name__ == "__main__":
    main()
