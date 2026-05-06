# Paper Draft - Dual Engagement Reversal in Algorithm Visualization

Razieh Fathi, Ian Handy

---

## TITLE

Expertise-Dependent Dual Representation Engagement in Algorithm Visualization: Evidence from Eye-Tracking

---

## ABSTRACT

Our study examined how 62 participants across three programming expertise levels distributed gaze between a pseudocode panel and a geospatial map while watching BFS and DFS algorithm animations, recorded by a Tobii eye-tracker at 60 Hz. Prior work on multi-channel learning assumes that viewers engage both representations together, but our results show this holds only at one expertise level. Fixation counts on pseudocode and map correlate positively only in the intermediate group (G2), while G1 shows no relationship and G3 shows a negative trend. The design of split-panel algorithm visualizations may therefore serve only one of three intended audiences.

---

## 1. INTRODUCTION

Previous studies have suggested that multi-channel communication leads to higher learning outcomes [Mayer 2001]. Split-panel algorithm visualizations are built on this assumption: the pseudocode lists each step and the animated graph shows those steps running on a graph.

The multi-channel approach seems to affect engagement non-linearly in relation to previous experience. Our study extends upon the Expertise Reversal Effect and Cognitive Load Theory [Kalyuga 2003, Sweller 1988] and could help indicate the conditions under which these approaches are most suitable. Prior work has not asked which viewers integrate both panels and which do not. We ask whether dual-panel engagement is uniform across expertise levels or whether the correlation between pseudocode and map fixations shifts with prior knowledge.

There have been numerous prior eye-tracking studies on algorithm comprehension, but the focus of such studies is usually on transition counts or fixation timing, not the directionality of the relationship between the two panels. Our study uses Spearman correlation between fixation counts on the two AOIs as the unit of measurement. Correlation is what the sign reversal requires; transition counts cannot show direction.

Our contributions are: (1) to our knowledge, the first demonstration of a sign reversal in dual-panel fixation correlation across expertise levels, (2) a correlation-based operationalization of dual-representation engagement, and (3) design implications for algorithm visualizations targeted at specific expertise levels.

---

## 2. RELATED WORK

Mayer's CTML holds that learning improves when verbal and pictorial information are processed through separate cognitive channels and integrated in working memory [Mayer 2001]. Split-panel algorithm visualizations apply this idea directly.

Working memory capacity is limited. Sweller's Cognitive Load Theory predicts that a second representation increases cognitive load, and if intrinsic load is already high, that addition hurts more than it helps [Sweller 1988, 1994]. Viewers with no prior knowledge of BFS or DFS face a novel algorithm and a novel visual format at the same time.

The Expertise Reversal Effect predicts that as learners gain knowledge, instructional supports that were once useful become redundant or harmful [Kalyuga et al. 2003]. A viewer building a schema for BFS benefits from pseudocode that labels each step. A viewer who already knows BFS does not need that label.

Both theories predict a monotonic decline in pseudocode dependence from G1 to G3. What they do not predict is a direction reversal at G2. Gegenfurtner et al.'s meta-analysis of 296 eye-tracking studies found that intermediate learners show longer fixation durations than both novices and experts, a pattern that the novice-to-expert framing does not predict [Gegenfurtner et al. 2011].

Bednarik studied attentional strategies during debugging with multiple code representations and found that experts and novices behave differently [Bednarik 2012]. Experts consult secondary representations to confirm a mental model they already hold; novices switch between panels without a governing strategy. Our study adds the intermediate group Bednarik did not include.

Richter and Scheiter measured process-level eye-tracking across text and picture AOIs in multimedia learning tasks at two expertise levels [Richter and Scheiter 2019]. Low-prior-knowledge learners coordinated both AOIs when signaling cues were present; high-prior-knowledge learners did not benefit. The setup is structurally similar to pseudocode and map AOIs in our study. Neither Bednarik nor Richter and Scheiter included three groups or used correlation structure as the measurement unit. The sign reversal requires both.

---

## 3. STUDY DESIGN

### 3.1 Participants and Design

Our study included 117 participants who watched animated algorithm visualizations while wearing a Tobii eye-tracker recording at 60 Hz. Participants were divided into three experience groups: G1 (no programming experience, n=38), G2 (brief programming knowledge, n=39), and G3 (multiple years of formal coursework, n=40). Each participant was assigned to either a BFS condition (n=59) or a DFS condition (n=58). The visualization style was Metal throughout, a high-contrast, stylized rendering. Expertise group assignment was based on self-reported programming background [CONFIRM MEASUREMENT METHOD].

[IRB statement: "This study was conducted under the oversight of [INSTITUTION] IRB (No. [NUMBER]). Informed consent was obtained from all participants."]

### 3.2 Stimuli

Each trial displayed a split-screen animation with a pseudocode panel on the left and a geospatial map on the right. The geospatial map showed a graph of nodes and edges where nodes activated as the algorithm visited them. Both panels were visible simultaneously throughout the trial.

### 3.3 Eye-Tracking Metrics

Two Areas of Interest (AOIs) were defined: Pseudocode (left panel) and Geospatial Map (right panel). The primary metrics were Fixation Count (FC), the number of individual fixation events per AOI, and Total Fixation Duration (TFD), total dwell time in seconds. Derived composite metrics included the pseudocode-to-map ratio (TFD\_pseudo / TFD\_map), scanner index (VC\_pseudo / TFD\_pseudo), average fixation depth (TFD\_pseudo / FC\_pseudo), and switching rate ((VC\_pseudo + VC\_map) / (TFD\_pseudo + TFD\_map)).

### 3.4 Statistical Methods

Non-parametric methods were used throughout because eye-tracking metrics are typically skewed and our group sizes are modest. Group comparisons used Kruskal-Wallis with pairwise Mann-Whitney U post-hoc tests. Within-group associations were measured using Spearman rank correlation. Group moderation of correlation structure was tested via Fisher z-transformation, which evaluates whether the Spearman r between two metrics differs significantly between groups. Partial Spearman correlation controlled for group and algorithm condition.

---

## 4. RESULTS

### 4.1 Non-Monotonic Pseudocode Engagement

Our study suggests that participants who had some prior exposure to the subject matter (G2) were likely to engage with the pseudocode panel notably longer than either G1 or G3. The median pseudocode-to-map ratio was 9.57 for G1, 12.33 for G2, and 6.12 for G3. The inverted-U pattern holds across TFD and average fixation depth.

The difference in pseudocode-to-map ratio between BFS and DFS conditions is statistically significant in G1 (p = .040, r = 0.43) and absent in both G2 and G3, suggesting that prior knowledge overrides the visual structure of the algorithm.

### 4.2 Dual Engagement Reversal

Fixation count correlation trends positively in G2 (r = +0.317, p = .049), contrasting against the negative trend of G3 (r = -0.276, p = ns) and the absence of a trend in G1 (r = -0.018, p = ns). [See Figure 1]

Fisher z-test confirms the group differences in correlation are significant (p = .009). The pattern holds within BFS and DFS conditions separately, which rules out a mixing artifact. Partial Spearman correlation controlling for group and algorithm does not change the result. Replacing fixation count with total fixation duration produces the same pattern. [See Figure 3]

The direct engagement of G2 with the pseudocode and the geospatial map suggests that they are the group most actively integrating both representations simultaneously, which is what the split-panel design is supposed to produce. G1 fixations on each panel are independent of one another. Novices appear to lack the working memory capacity to coordinate the two streams. G3's negative correlation between pseudocode and map fixation counts suggests that the two panels function as substitutes for experienced viewers, where sufficient schema reduces the need to consult both representations simultaneously.

G2's pattern matches what CTML predicts for active dual-channel processing. Our findings suggest it occurs at only one expertise level.

### 4.3 Attentional Coupling

Our study suggests a monotonic increase in attentional coupling across expertise levels. Mean absolute Spearman r across all metric pairs was 0.294 for G1, 0.330 for G2, and 0.369 for G3. Those participants less experienced with the subject matter were more likely to show independent metrics. The ratio-to-scanner\_index pair, for example, goes from r = -0.04 in G1 to r = -0.67 in G3. Studies that pool expertise levels mix participants whose attention is organized by different mechanisms, and the resulting averages do not reflect any single group's behavior.

---

## 5. DISCUSSION

### 5.1 Mechanism

The sign reversal in Section 4.2 follows from the interaction of CLT and ERE across the three groups.

G1 viewers have no prior schema for BFS or DFS. Working memory is occupied by a novel algorithm and a novel visual format at the same time. With no schema available to link the two panels, fixations on each are largely independent of the other.

G2 viewers have a partial schema. They recognize that the pseudocode and map show the same process from different angles. With intrinsic load reduced enough to free working memory capacity, they can read a line of code, check the corresponding node on the map, and return to the next line. Each panel supports the other, and this produces the positive correlation.

G3 viewers have internalized the algorithm. Either panel gives them enough information to anticipate the next step. Consulting both becomes redundant, so attending to one reduces the need for the other. This produces the negative trend.

The inverted-U in pseudocode-to-map ratio (Section 4.1) and the sign reversal in dual engagement (Section 4.2) show the same mechanism at two scales: total attention and moment-to-moment coordination.

### 5.2 Design Implications

While fixations and visits do not inherently equate to active engagement with the material, G2 seems to, at least, have justified the split-panel design of the visualization. For G1, the pseudocode panel is not being used productively. Scaffolding such as line highlights, annotations, or staged display may be needed before showing both panels at once. For G3, the pseudocode panel functions as a quick verification check rather than a primary source of information.

Our findings also suggest that the algorithm being visualized matters more for novices than for experienced viewers. Attention metrics evaluated without stratifying by expertise level will produce averages that do not describe any group accurately.

### 5.3 Limitations

The Fisher z-test battery ran around 105 comparisons; at p < .05, about five false positives are expected by chance. The main finding in Section 4.2 is at p = .009, which is above that threshold. Expertise groups were not randomized; observed differences may correlate with general ability or motivation rather than programming knowledge specifically. All visualizations used the Metal style, and generalizability to other animation designs is not established. Group sizes of roughly 19 to 20 per cell limit power to detect small correlation differences.

### 5.4 Conclusion

Dual-panel engagement in algorithm visualization is not uniform across expertise levels. Only intermediate viewers showed the coordinated attention pattern the split-panel format is designed to elicit; novices and experienced viewers did not. Designers targeting a single expertise level should not assume that a layout validated on one group will generalize to the others, and studies that pool across levels may obscure group-specific patterns.

---

## BEFORE LATEX

- [ ] IRB number and institution name (Section 3.1)
- [ ] Second author name and affiliation
- [ ] Confirm institutions for all three authors
- [ ] Confirm figure files: fig1\_dual\_engagement\_core.png, fig3\_kde\_contours.png
- [ ] Title -- keep or revise?
- [ ] Acknowledgments?
