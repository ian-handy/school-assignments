# Reproducibility Flags — paper-trim-B.tex

Surfaced 2026-04-26 by re-running an independent pipeline
(`regen_figures.py` + `verify_claims.py` at the data root) against the
raw Tobii `.xls` exports. **Direction of every reported result holds
in both pipelines**; magnitudes drift in ways that need your input
before submission.

## 1. Sample size — n=19/21/20 vs my 21/25/22

Body text §3.3 says: *"117 trials (n=59 BFS, n=58 DFS), G1=19, G2=21,
G3=20."* Independent pipeline finds 115 trials (58 BFS + 57 DFS) and
21/25/22 unique participants after normalizing IDs. Off by 2 trials
and +8 unique IDs.

**Need from you:** the exclusion criterion that produced n=19/21/20.
Calibration-quality flag? Per-trial AOI-dwell minimum? Hand-curated
list of analyzable participants? Once documented, I can match it
exactly.

## 2. §4.2 TFD G2 ρ p-value — paper says <.050, recompute says .063

Body text says ρ(G2)=$-$.457, $p$<.050. My pipeline (BFS+DFS averaged
per normalized participant, n=25) gives ρ=$-$.378, p=.063.

This is the only place where a body-text significance claim does not
hold under a reasonable reanalysis. The "monotonic" framing in §4.2
depends on G2 being significant. Worth confirming the original
analysis path (combined-trial Spearman? Per-algorithm averaged then
correlated? Median collapse instead of mean?).

## 3. §4.3 all-pair mean |ρ| — paper says .294/.330/.369, recompute .368/.479/.498

Substantial gap. My pipeline gives systematically higher values
across any reasonable metric set (8 metrics or 15 metrics). The
gradient direction (G1 < G2 < G3) holds in both, but absolute
magnitudes don't.

**Need from you:** the metric list used for the original computation
and whether trial-level or participant-level data was correlated.

## 4. §5.3 "105 Fisher z tests"

The number 105 factors as C(15,2) = 105 metric-pair tests, or 15
metrics × 7 group-comparisons. Either way, multiple-comparison
correction at α=.05/105 = .00048 means the main TFD G1-vs-G3 contrast
($p$=.04) does **not** survive Bonferroni at this scale. The current
phrasing "*survives that threshold with some modest correction
applied*" is vague.

**Need from you:** the actual number of tests performed and the
correction method intended (Bonferroni? Holm? FDR?). If 105 is a
hypothetical illustration rather than a real test count, rephrase to
make that clear.

## 5. Inverted-U medians — drift but direction holds

Paper §4.1: medians 9.57 / 12.33 / 6.12 (combined). Recompute: 10.24
/ 13.61 / 7.17. ~7-15% higher across all groups; same shape; same
inverted-U with G2 at apex. Most likely explained by the n
discrepancy (item 1).

## What's verified end-to-end (no flag)

- Every figure caption number on B's figures matches `regen_figures.py`
  output exactly:
  - DFS-only TFD G3 ρ = $-$.660, $p$ = .002
  - DFS-only mean |ρ| coupling: .368 / .483 / .605
  - DFS-only inverted-U direction (G2 highest, G3 lowest)
- §5.3 "G1 vs G3, $p$=.04" — Fisher z reproduces at .039
- Ratio↔scanner-index gradient direction — reproduces (G3 ≈ $-$.73)
- Scanner index, switching rate group differences — both $p$ > .10
  (Kruskal); fixation depth $p$ = .12 (also > .10, hence the
  "$p$>.10" wording in §4.3 rather than "$p$>.20")

## How items 1–5 affect submission readiness

None of these change the paper's three contributions. The headline
("substitution grows with expertise") holds under any reasonable
pipeline. Items 1–4 affect *precision* and *defensibility under
hostile review*, not direction.

Lowest-cost fixes:
- Item 1: document exclusion criterion in §3.3 once you confirm it.
- Item 2: confirm the analysis path; if the original pipeline genuinely
  gave G2 p<.05, document the pipeline; otherwise relax to "p<.10" or
  "approached significance."
- Item 3: confirm metric set and provide it as a footnote or
  supplemental table.
- Item 4: replace "105" with the real count, or rephrase as "expected
  false positives at α=.05 across the metric battery."
- Item 5: auto-resolves once item 1 is resolved.
