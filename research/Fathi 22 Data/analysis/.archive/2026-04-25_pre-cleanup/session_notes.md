# Fathi 22 Data — Session Notes
*Session date: 2026-04-09*

---

## Study Overview

Eye-tracking study of animated BFS and DFS algorithm visualizations (Metal style).

- **N:** 117 participants (59 BFS, 58 DFS)
- **Eye-tracker:** Tobii, 60 Hz
- **Two AOIs:** Pseudocode panel (left), Geospatial map (right)
- **Three experience groups:**
  - G1 — No programming experience (19 BFS + 19 DFS)
  - G2 — Brief programming knowledge (20 BFS + 19 DFS)
  - G3 — Multiple years of coursework (20 BFS + 20 DFS)

### Key metrics

| Metric | Definition |
|--------|------------|
| TFD | Total Fixation Duration — seconds spent fixating an AOI |
| TTFF | Time to First Fixation — ms until first eye-landing on an AOI |
| FC | Fixation Count — number of individual fixation events |
| VC | Visit Count — number of separate entries into an AOI |
| Fix Before | Fixations on other AOIs before first pseudocode fixation |
| FFD | First Fixation Duration — duration of the very first fixation |
| ratio | tfd_pseudo / tfd_map — how much more time spent on code vs map |
| scanner_index | vc_pseudo / tfd_pseudo — visits per second on pseudocode |
| avg_fix_depth | tfd_pseudo / fc_pseudo — mean fixation duration on pseudocode |
| switching_rate | (vc_pseudo + vc_map) / (tfd_pseudo + tfd_map) — AOI visits per second |

---

## The Three Notebooks

### `findings_documentation.ipynb` — Primary findings report
All seven findings documented with both traditional and cutting-edge visualizations.

### `metal_group_correlations.ipynb` — How relationships change with expertise
Fisher z-transformation battery testing which metric correlations are moderated by experience group. 27 of 105 pairs show significant group moderation.

### `metal_bfs_dfs.ipynb` — Algorithm comparison (BFS vs DFS)
Focused comparison collapsing across groups. Tests whether the algorithm being visualized changes eye-tracking patterns independent of who is watching.

---

## All Seven Findings

### Finding 1 — Algorithm determines when you first look at code (TTFF)
- BFS median TTFF: 18.86 ms vs DFS 25.47 ms (p < .001, r = 0.954)
- Fixations before: BFS 54.5 vs DFS 76.0 (r = 0.782, p < .001)
- BFS expands suddenly across many nodes → viewers must consult pseudocode immediately to orient
- DFS proceeds step-by-step → map is followable without code

### Finding 2 — DFS produces deeper but delayed pseudocode engagement
- Avg fixation depth: BFS 0.547s vs DFS 0.693s (p < .001, r = 0.450)
- DFS viewers make fewer, longer fixations — they are *reading* the code
- BFS viewers make more, shorter fixations — they are *checking* the code

### Finding 3 — Expertise inverted-U: intermediates read pseudocode most
- Ratio: G1 = 9.57, G2 = 12.33, G3 = 6.12
- BFS/DFS gap: significant for G1 (p = .040), disappears for G2 and G3
- G1 lacks schema to use code purposefully
- G2 leans on code as a crutch
- G3 has internalized the algorithm — barely needs the pseudocode

### Finding 4 — BFS/DFS gap collapses with expertise
- Novices are algorithm-sensitive; experts treat BFS and DFS similarly
- The visualization's structure matters more for inexperienced viewers

### Finding 5 — Gaze style is a stable trait; allocation is algorithm-driven
Within-person correlations (52 participants who saw both):
- Scanner index: r = 0.589, p < .001 (**stable trait**)
- Avg fixation depth: r = 0.627, p < .001 (**stable trait**)
- Switching rate: r = 0.569, p < .001 (**stable trait**)
- Pseudocode/map ratio: r = 0.155, ns (**not stable — algorithm-driven**)

*How* someone looks (fast/slow, deep/shallow) is a personal cognitive trait. *Where* they look depends on the algorithm.

### Finding 6 — Intermediates show parallel engagement; novices and experts don't ⭐ *Strongest for paper*
See full section below.

### Finding 7 — Expertise tightens the attentional system (coupling hypothesis)
- Mean |Spearman r| across all metric pairs: G1 = 0.294, G2 = 0.330, G3 = 0.369
- Example pairs that strengthen dramatically:
  - ratio ↔ scanner_index: G1 r = −0.04 → G3 r = −0.67
  - scanner_index ↔ tfd_map: G1 r = +0.07 → G3 r = +0.66
  - ratio ↔ switching_rate: G1 r = −0.22 → G3 r = −0.65
- Novices' attention metrics are mostly independent. Experts' form a tightly coupled architecture.

---

## Finding 6 — Full Detail

### The result

| Group | Spearman r (fc_pseudo vs fc_map) | p | Pattern |
|-------|----------------------------------|---|---------|
| G1 — No experience | −0.018 | ns | Independent |
| G2 — Brief knowledge | **+0.317** | **.049** | **Parallel engagement** |
| G3 — Years of coursework | −0.276 | ns | Trade-off |

The sign **reverses** from G2 to G3. This is not a monotonic trend — G2 is doing something qualitatively different.

### Why it's the strongest finding
- Non-obvious: you'd expect a monotonic increase, not a direction reversal
- Well-supported: Fisher z confirms group moderation (p = .009); pattern persists within BFS and DFS separately; survives partial correlation controls
- Theoretically rich: engages CLT, ERE, CTML, and dual-coding simultaneously
- Practically actionable: G2 is the design target for integrative visualization

### How to explain it

**One sentence:** Novices and experts both treat the code and map as competing for attention, but intermediate learners are the only ones who use both at the same time.

**The mechanism (CLT + ERE):**
- G1: high intrinsic load, no schema → working memory saturated → sequential, independent fixations
- G2: partial schema reduces load enough to coordinate both panels → each representation clarifies the other → positive feedback loop → parallel engagement
- G3: automated schema → treats both representations as redundant → strategic trade-off, one panel substitutes for the other

**For a presentation:**
Setup: Does looking at code more predict more or less map attention?
Expected: monotonic trend — novices can't integrate, experts can.
Actual: direction reverses. G2 is the only group where both go up together.
Punchline: G2 is the only group actively integrating both representations in real time. That's dual-coding in action — and it only exists at one expertise level.

---

## Visualization Inventory

### `metal_bfs_dfs.ipynb`
| Figure | Type | What it shows |
|--------|------|---------------|
| 1 | 8-panel boxplot + strip | Distribution overview across all key metrics, BFS vs DFS |
| 2 | Violin + strip | 4 key metrics with Mann-Whitney p-values |
| 3 | Scatter (2 panels) | Fix before vs ratio — DFS creates early-map trap (r = −0.297); BFS doesn't |
| 4 | Scatter (2 panels) | First fixation duration vs total — no predictive relationship in either algorithm |
| 5 | 2×2 scatter | Switching rate vs ratio and depth — all four panels negative (switching = fragmentation) |
| 6 | Scatter with IDs | Within-person stability: BFS ratio vs DFS ratio — points scatter (r = 0.155, ns) |
| 7 | Dual heatmap | Correlation matrices side by side for BFS and DFS |

### `metal_group_correlations.ipynb`
| Figure | Type | What it shows |
|--------|------|---------------|
| 1 | Dual heatmap + Fisher z | Which metric relationships are moderated by group |
| 2 | Delta heatmap (G3 − G1) | Which relationships strengthen or dissolve with expertise |
| 3 | 3-panel scatter | Dual engagement: G1 flat, G2 positive slope, G3 negative slope |
| 5 | Multiple scatter | Key pairs (scanner ↔ tfd_map, ratio ↔ switching) by group |
| 6 | 3-panel scatter by algo | Dual engagement split by BFS/DFS — rules out mixing artifact |
| 7 | Raw vs partial matrices | Which correlations were genuine vs confounded |
| 8 | Bar chart | Coupling strength monotonically increases G1 → G3 |

### `findings_documentation.ipynb`
| Figure | Type | What it shows |
|--------|------|---------------|
| F1 | Raincloud | TTFF by algorithm and group — full distribution including outliers |
| F2 | Ridge plot | Avg fixation depth distribution shift across groups |
| F3 | Beeswarm | Ratio by group — within-group variance, inverted-U pattern |
| F4 | Slope chart | Per-participant BFS→DFS ratio shift — crossing lines show instability |
| F5 | Dumbbell | Within-person stability: short lines = stable trait, long lines = algorithm-driven |
| F6 | 2D KDE contour | NE tilt = positive corr, NW tilt = negative, round = zero — readable without numbers |
| F7 | Network graph | Correlation topology: G1 sparse, G3 dense — coupling hypothesis visualized |

### Cutting-edge visualization logic
- **Boxplot** → answers "is there a difference?"
- **Violin/raincloud/ridge/beeswarm** → answers "what *kind* of difference, and how much variance?"
- **Slope chart/dumbbell** → answers "is this a stable trait or a situational response?"
- **Network graph/delta heatmap** → answers "does expertise *reorganize* the whole attentional system?"

---

## Related Research Papers

### Theoretical foundations

**Cognitive Load Theory**
- Sweller, J. (1988). Cognitive load during problem solving. *Cognitive Science*, 12(2), 257–285.
- Sweller, J. (1994). Cognitive load theory, learning difficulty, and instructional design. *Learning and Instruction*, 4(4), 295–312.
- Mechanism: WM capacity is limited. G1 saturated → sequential fixations. G2 partial schema → coordination possible. G3 automated schema → redundancy trade-off.

**CTML (Dual-Coding / Multimedia Learning)**
- Mayer, R. E. (2001). *Multimedia learning*. Cambridge University Press.
- Mayer, R. E. (2023). The past, present, and future of the CTML. *Educational Psychology Review*, 35, 8.
- Mayer & Moreno (1998). A split-attention effect in multimedia learning. *Journal of Educational Psychology*, 90(2), 312–320.
- Provides the motivating framework (dual channels, integration required) but does not predict the sign reversal.

**Expertise Reversal Effect**
- Kalyuga, S., Ayres, P., Chandler, P., & Sweller, J. (2003). The expertise reversal effect. *Educational Psychologist*, 38(1), 23–31.
- Kalyuga, S. (2007). Expertise reversal effect and its implications. *Educational Psychology Review*, 19(4), 509–539.
- Supports directionality (novice-to-expert shift) but does not explicitly predict the intermediate peak.

### Empirical analogs

**Closest CS-domain analog**
- Bednarik, R. (2012). Expertise-dependent visual attention strategies develop over time during debugging with multiple code representations. *International Journal of Human-Computer Studies*, 70(2), 155–168.
- Experts: "confirm the model" strategy — code first, visualization to validate → trade-off. Novices: bounce between both without integration → independence. Only two groups; your study adds the intermediate and reveals the sign reversal.

**Closest methodological analog**
- Richter, J., & Scheiter, K. (2019). Studying the expertise reversal of the multimedia signaling effect at a process level. *Instructional Science*, 47(5), 555–580.
- Process-level eye-tracking across text and picture AOIs. Low-prior-knowledge students coordinate AOIs when signaling present; high-prior-knowledge students don't benefit. Structural parallel to pseudocode vs map.

**Meta-analytic support for non-monotonic intermediate patterns**
- Gegenfurtner, A., Lehtinen, E., & Säljö, R. (2011). Expertise differences in the comprehension of visualizations: A meta-analysis. *Educational Psychology Review*, 23(4), 523–552.
- Meta-analysis of 296 eye-tracking studies: intermediates show *longer* fixation durations than both novices and experts — qualitatively distinct, not just in-between. Closest existing evidence for a non-monotonic expertise effect in eye-tracking.

**ERE in science animation (direct domain analog)**
- Homer, B. D., & Plass, J. L. (2010). Expertise reversal for iconic representations in science visualizations. *Instructional Science*, 38(4), 381–401.
- Icons in chemistry animations help novices but not experts. Direct analog to map visualization in BFS/DFS study.

**CS education — pseudocode eye-tracking**
- Obaidellah et al. (2020). A fine-grained assessment on novice programmers' gaze patterns on pseudocode problems. *ETRA '20*.
- Methodological precedent for AOI-based fixation analysis on pseudocode in CS education.

### How to frame the gap

> Prior work has shown that dual-representation multimedia benefits are expertise-dependent (Kalyuga et al., 2003; Mayer, 2001) and that eye-tracking reveals qualitative differences in how experts and novices coordinate visual attention across representations (Bednarik, 2012; Richter & Scheiter, 2019). However, these studies have typically operationalized expertise as a binary (novice vs. expert) and measured coordination via transition counts or fixation timing rather than within-group correlation structure. The present study extends this work in two ways: (1) a three-group design that reveals a non-monotonic pattern in which intermediate learners are the only group showing positive within-person coordination between representations, and (2) a correlation-based metric that captures integrated dual-representation engagement as a property of the attentional system rather than a simple count of fixations or transitions.

### Citation priority

| Priority | Paper |
|----------|-------|
| Must cite | Kalyuga et al. (2003) ERE — core theoretical framework |
| Must cite | Mayer (2001) CTML — motivating framework |
| Must cite | Bednarik (2012) — CS domain, closest behavioral analog |
| Must cite | Richter & Scheiter (2019) — closest methodological analog |
| Must cite | Gegenfurtner et al. (2011) — meta-analytic support for non-monotonic intermediate |
| Should cite | Sweller (1988/1994) CLT — mechanistic foundation |
| Should cite | Homer & Plass (2010) — ERE in science animation |
| Optional | Mayer & Moreno (1998) — split-attention foundational |
| Optional | Obaidellah et al. (2020) — pseudocode eye-tracking in CS ed |

---

## Files in This Directory

| File | Description |
|------|-------------|
| `finding6_dual_engagement.ipynb` | Main analysis notebook — 7 figures focused on Finding 6 |
| `session_notes.md` | This file |
| `.archive/` | All previous notebooks and output images |

### `finding6_dual_engagement.ipynb` contents
| Figure | What it shows |
|--------|---------------|
| 1 — Core scatter | Sign reversal across G1/G2/G3, BFS and DFS distinguished by marker shape |
| 2 — By algorithm | Pattern persists within BFS and DFS separately — rules out mixing artifact |
| 3 — KDE contours | Ellipse orientation shows direction without numbers (NE = positive, NW = negative) |
| 4 — Summary table | Exact r, p, n for every group × algorithm combination |
| 5 — Fisher z-test | Are the group differences in r themselves statistically significant? |
| 6 — CI bar chart | Sign reversal with uncertainty intervals, combined and split by algorithm |
| 7 — TFD robustness | Same pattern holds when using total fixation duration instead of fixation count |
