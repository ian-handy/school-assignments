# Style and Accuracy Reference
*Internal reference. Do not use em-dashes or invisible characters in any paper writing.*

---

## Ian's Writing Style (derived from sentence_workshop.md)

- Formal register, no jargon for jargon's sake
- Hedges appropriately: "seems to suggest", "were likely to", "are less likely to"
- Short, declarative sentences -- no run-ons
- Refers to groups as G1, G2, G3 directly in prose
- Academic vocabulary, plain construction
- Does not editorialize or dramatize findings
- Limitation acknowledgment built naturally into sentences (see sentence 10)
- Uses "our study" (first person plural) -- note: reconcile with stated preference for third person before final LaTeX

**No em-dashes. No invisible characters.**

---

## Accuracy Check -- All 10 Sentences

### Sentence 1 -- ACCURATE with one note
> "Previous studies (CTML Mayer 2001) have suggested that multi-channel communication leads to higher engagement."

CTML is about learning outcomes, not engagement specifically. "Higher engagement" is a weaker and slightly different claim than what Mayer argues. Recommend: "higher learning outcomes" or "more effective knowledge acquisition." Not wrong, just imprecise.

Citation format "(CTML Mayer 2001)" is informal -- will be replaced with proper TVCG citation format in LaTeX.

---

### Sentence 2 -- ACCURATE
> "The multi-channel approach seems to affect engagement non-linearly in relation to previous experience. The research extends upon the Expertise Reversal Effect and Cognitive Load Theory and, with further studies, could help indicate the outer bounds of when these approaches are most suitable."

Correct. Non-linear is the right characterization of the inverted-U. ERE and CLT are the right anchors. "Outer bounds" is slightly vague but not inaccurate.

---

### Sentence 3 -- ACCURATE with one note
> "There have been numerous studies relying on eye tracking data, but the focus of such studies is usually on the transition counts or fixation timing, not the directionality of the movement."

"Directionality of the movement" could be read as spatial direction of eye movement. The actual gap is about whether the correlation between two AOI metrics is positive or negative -- the directionality of the relationship, not the movement itself. Recommend replacing "movement" with "relationship" or "association."

---

### Sentence 4 -- ACCURATE with one note
> "Our study seems to suggest that participants who had some exposure to the subject matter (G2) were likely to engage with it for notably longer than G1 and G3."

Data confirms: median ratio G1 = 9.57, G2 = 12.33, G3 = 6.12. G2 peaks. Accurate.

Note: "engage with it" is vague. "It" needs a referent -- the pseudocode panel specifically. Not the visualization generally.

"Our study" is first person -- flag for third person pass.

---

### Sentence 5 -- INACCURATE, needs revision
> "The gap between BFS and DFS in G1's fixation counts are an anomaly that subsides in G2 and further subsides in G3."

Two problems:

1. The gap does not "further subside" from G2 to G3. It disappears entirely at G2 (p = .60) and is still absent at G3 (p = 1.00). There is no gradient -- it is gone by G2. "Further subsides" implies a continued decline, which is not supported.

2. The metric in question is the pseudocode-to-map ratio (TFD_pseudo / TFD_map), not raw fixation counts. Fixation count is a different metric.

3. "Anomaly" is the wrong framing. This is a meaningful finding, not a data irregularity.

Suggested revision direction: The difference in pseudocode-to-map ratio between BFS and DFS conditions is significant in G1 (p = .040, r = 0.43) and absent in G2 and G3.

---

### Sentence 6 -- ACCURATE
> "Fixation count correlation trends positively in G2, contrasting against the negative trend of G3 and the absence of a trend in G1."

Accurate. G1: r = -0.018 (ns), G2: r = +0.317 (p = .049), G3: r = -0.276 (ns). Clean and correct. Note that G3's negative trend is not statistically significant -- calling it a "trend" is appropriate as a directional observation, not a firm claim.

---

### Sentence 7 -- ACCURATE with one note
> "The direct engagement of G2 with the pseudocode and the graphics suggests that they are the group most likely to observe all relevant content that occupies display real estate."

Accurate in meaning. "Display real estate" is informal -- may need tightening in final version. "Observe all relevant content" slightly undersells the mechanism: G2 is not just observing both, they are actively integrating them (reading code, verifying on graph, returning). Worth preserving that active integration angle.

---

### Sentence 8 -- INACCURATE, needs revision
> "G3's observational trends suggest that they are less likely to spend significant time looking at sections of the screen outside of their preferred fixation."

This misrepresents the finding. G3 does not have a single "preferred fixation" they anchor to. The finding is that G3 treats the two panels as substitutes: they extract what they need from one and do not need to consult the other. The panels are redundant to them, not because they ignore one, but because their schema makes one sufficient to confirm what the other shows. "Preferred fixation" implies spatial anchoring; the actual mechanism is informational redundancy (ERE).

Suggested revision direction: G3's negative correlation between pseudocode and map fixation counts suggests that the two panels serve as substitutes rather than complements for experienced viewers.

---

### Sentence 9 -- ACCURATE
> "Our study suggests a monotonic increase across all metric pairs with experience. Those participants less experienced with the subject matter were more likely to show independent metrics."

Accurate. Mean absolute Spearman r: G1 = 0.294, G2 = 0.330, G3 = 0.369. Monotonic increase confirmed. "Independent metrics" correctly captures the G1 decoupling. "Our study" is first person -- flag for third person pass.

---

### Sentence 10 -- ACCURATE
> "While fixations and visits do not inherently equate to active engagement with the material, G2 seems to, at least, have justified the split window design of the demonstration."

Accurate. Includes an appropriate methodological caveat about eye-tracking limitations. Good sentence.

---

## Sentences Cleared for Paper Use (no revision needed)

- Sentence 2
- Sentence 6
- Sentence 9
- Sentence 10

## Sentences Usable With Minor Wording Fix

- Sentence 1: change "engagement" to "learning outcomes"
- Sentence 3: change "directionality of the movement" to "directionality of the relationship"
- Sentence 4: replace "it" with "the pseudocode panel"; third person pass
- Sentence 7: optional -- add active integration angle to "observe"

## Sentences Needing Substantive Revision Before Use

- Sentence 5: "further subsides" is not supported; "fixation counts" is the wrong metric; remove "anomaly"
- Sentence 8: "preferred fixation" misrepresents the ERE/redundancy mechanism

---

## Key Data Points (verified against session_notes.md)

Finding 3 -- Inverted-U ratio:
G1 = 9.57, G2 = 12.33, G3 = 6.12

Finding 4 -- BFS/DFS gap:
G1: p = .040, r = 0.43 (significant)
G2: p = .60 (not significant)
G3: p = 1.00 (not significant)
The gap disappears at G2. It does not gradually decline.

Finding 6 -- Dual engagement correlation (fc_pseudo vs fc_map):
G1: r = -0.018, p = ns
G2: r = +0.317, p = .049
G3: r = -0.276, p = ns
Fisher z group moderation: p = .009

Finding 7 -- Attentional coupling:
Mean absolute Spearman r: G1 = 0.294, G2 = 0.330, G3 = 0.369

Figures for paper:
fig1_dual_engagement_core.png -- scatter showing sign reversal, all three groups, BFS/DFS by marker shape
fig3_kde_contours.png -- KDE ellipses, NE tilt (G2 positive), NW tilt (G3 negative)
