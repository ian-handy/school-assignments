# Before Submitting

## Pivot status

- [x] **Framing pivoted** to TFD monotonic substitution (G1 r=-.03, G2 r=-.46 p=.04, G3 r=-.63 p=.003; Fisher z G1 vs G3 p=.04). FC sign reversal (G1 +.04, G2 +.33, G3 -.16) now reported as directional secondary result.
- [x] **Title updated** in paper.tex and draft1.md to: "Pseudocode-Map Substitution Grows with Expertise: An Eye-Tracking Study". Both synced.
- [ ] **Style-check the pivoted sections.** Every newly rewritten passage is wrapped in `^^ ... ^^` (in draft1.md) or `% ^^ ... % ^^` comment markers (in paper.tex). Grep for `^^` to find them.
- [ ] **Confirm N = 62.** Data files show 59 unique normalized participant IDs (Metal subset). Per-group participant counts used in reanalysis: G1=19, G2=21, G3=20 (sums to 60 because of one cross-group ID). Paper states 62 recruited with 19/21/20 analyzable -- confirm recruited vs analyzed counts.

## Figures (potential follow-up)

- [x] Figures regenerated at participant level: `fig1_dual_engagement_core.png` (FC scatter), `fig3_kde_contours.png` (FC KDE)
- [ ] **Decision:** current figures show FC (now the secondary finding). Consider regenerating one or both to show TFD (the primary finding) so the visual matches the lead text. Alternatively, keep as-is and let the figures illustrate the secondary FC pattern while TFD carries the numeric lead.
- [ ] Figure 1 caption ("G2 is the only group where the two panels trend together") and Figure 3 caption (describes FC orientation) still describe the FC figures accurately; may want updating if figures are regenerated.
- [ ] Review figures visually before submission.

## Required placeholders

- [ ] IRB number and institution name (Section 3.1 in paper.tex, [INSTITUTION] and [NUMBER])
- [ ] Second author -- fill in `\authororcid{[SECOND AUTHOR]}{0000-0000-0000-0000}` in paper.tex, or remove if keeping two-author format
- [ ] Institutions for all authors -- fill in `\authorfooter` block in paper.tex
- [ ] ORCID IDs for all authors -- replace `0000-0000-0000-0000` placeholders
- [ ] Acknowledgments -- currently `[ACKNOWLEDGMENTS]`
- [ ] Expertise measurement method in Section 3.1 -- currently "self-reported programming background [CONFIRM MEASUREMENT METHOD]". Options: self-report survey, course enrollment records, pretest, other.
- [ ] Supplemental materials URL in Section "Supplemental Materials" -- currently `[URL]`

## References

- [ ] Verify all DOIs in paper.bib before submission

## Before compiling

- [ ] Strip the `% ^^` / `^^` review markers once style-checked (grep for `^^` in paper.tex and draft1.md).

## Open items flagged 2026-04-22 (methods merge)

- [ ] **Confirm full references with Razieh** for the three new bib entries (currently stubs with `[CONFIRM...]` fields that will appear in the rendered PDF):
  - `Olson2015Transfer` — referenced in §3.1 intro sentence on transfer of learning
  - `VanMerrienboer2003Taking` — likely van Merriënboer, Kirschner & Kester (2003), *Taking the Load Off a Learner's Mind*, Educational Psychologist 38(1), 5–13 — verify with Razieh
  - `Teresco2018METAL` — the METAL project publication; verify Teresco et al. full reference
- [ ] **Pseudocode AOI discrepancy.** `IRN-bft_All_AOIs.txt` names the top-left AOI "Pseudocode" but the `Group1_DE-BFS_METAL_Heatmap.jpg` screenshot has "Trace Pseudocode" **unchecked** and shows the algorithm-visualization status + spanning-tree table in that region instead of pseudocode text. Either (a) the experimental stimulus had Trace Pseudocode on and the heatmap image is a different post-hoc render, or (b) "Pseudocode" in the AOI file was a label for the left-side information panel generally. Confirm with Razieh which, and update §3.4 / fig. caption accordingly.
- [ ] **Housekeeping — duplicate dif files.** `overleaf/untitled folder/` contains `dif.md` and `dif2.md` that are byte-for-byte identical (MD5 `3ba5d656…`). Candidate for cleanup before final merge.
- [ ] **Procedure subsection.** §3.5 is full of `[Confirm: …]` placeholders (location, calibration, order, duration, compensation, software/version). None of this is documented in the Fathi 22 folder; all fields need Razieh input before submission.
- [ ] **Subjects subsection.** Institution, IRB number, and expertise-measurement method still unresolved (overlaps with the "Required placeholders" list above).
