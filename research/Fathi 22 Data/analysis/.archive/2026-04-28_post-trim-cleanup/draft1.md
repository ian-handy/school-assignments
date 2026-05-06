# Pseudocode-Map Substitution Grows with Expertise

Razieh Fathi, Ian Handy

---

## Abstract

We tracked 62 participants across three levels of programming experience as they watched BFS and DFS algorithm videos with pseudocode on one side and a geospatial map on the other, using a Tobii eye-tracker at 60 Hz. Each saw both algorithms (117 trials). Per participant, the Spearman correlation between pseudocode and map total fixation duration (TFD) gets more negative with expertise: G1 r = -.03 (ns), G2 r = -.46 (p = .04), G3 r = -.63 (p = .003); Fisher z G1 vs G3 p = .04. The two panels trade off increasingly with expertise, consistent with the Expertise Reversal Effect. A matching directional trend in fixation count does not reach significance. Split-panel designs validated at one skill level may not generalize to others.

---

## 1. Introduction

Multi-modal presentations can improve learning [Mayer 2001], but the effect depends on the learner's prior experience. The Expertise Reversal Effect [Kalyuga 2003] and Cognitive Load Theory [Sweller 1988] both predict that instructional aids useful to novices become redundant for experts.

Most eye-tracking work on algorithm comprehension focuses on transition counts or fixation timing rather than the relationship between panels. A substitution pattern (time on one panel trading off against time on the other) needs a measure of association. We use Spearman correlation between dwell times on pseudocode and map to test whether that trade-off varies with expertise.

Contributions: (1) participant-level evidence that pseudocode and map dwell times trade off more as expertise grows; (2) a correlation-based operationalization of representation substitution; (3) design implications for split-panel visualizations targeted at specific expertise levels.

---

## 2. Related Work

Mayer's CTML holds that verbal and pictorial information processed through separate channels integrate more efficiently in working memory [Mayer 2001]. Split-panel algorithm visualizations apply this directly. Cognitive Load Theory adds that a second representation increases load, and if intrinsic load is already high, the second representation hurts more than it helps [Sweller 1988, 1994]. The Expertise Reversal Effect extends this: aids that help novices become redundant once learners develop a schema [Kalyuga 2003].

Gegenfurtner's meta-analysis of 296 eye-tracking studies finds intermediate learners fixate longer than both novices and experts, breaking the simple novice-to-expert story [Gegenfurtner 2011]. Bednarik shows experts and novices debug with different attentional strategies: experts confirm a mental model, novices switch between panels without a governing strategy [Bednarik 2012]. Richter & Scheiter find that low-prior-knowledge learners coordinate text and picture AOIs when signaling cues are present; high-prior-knowledge learners don't benefit [Richter & Scheiter 2019].

Neither Bednarik nor Richter & Scheiter included three expertise groups, and neither used correlation between dwell times as the measurement unit. Detecting a substitution gradient needs both.

---

## 3. Study Design

### 3.1 Participants

62 participants wore a Tobii eye-tracker at 60 Hz while watching animated BFS and DFS visualizations. They were split by prior experience: G1 (none), G2 (brief), G3 (years of formal coursework). Each saw both algorithms, yielding 117 trials (59 BFS, 58 DFS) after quality screening. All visualizations used the Metal style.

### 3.2 Stimuli and AOIs

Each trial showed a split screen with pseudocode on the left and a geospatial map (nodes and edges lighting up as the algorithm visited them) on the right. Two AOIs: Pseudocode and Map. Primary metrics were Fixation Count (FC) and Total Fixation Duration (TFD). Derived metrics: pseudocode-to-map TFD ratio (TFD_pseudo / TFD_map), scanner index (VC_pseudo / TFD_pseudo), average fixation depth (TFD_pseudo / FC_pseudo), and switching rate ((VC_pseudo + VC_map) / (TFD_pseudo + TFD_map)).

### 3.3 Statistics

We used non-parametric tests throughout: Kruskal-Wallis with Mann-Whitney U post-hoc for group comparisons, Spearman correlation within groups, and Fisher z for group moderation. Partial Spearman controlled for group and algorithm.

---

## 4. Results

### 4.1 Pseudocode engagement is non-monotonic

G2 looks at the pseudocode panel longer than either G1 or G3. Median pseudocode-to-map ratios: G1 = 9.57, G2 = 12.33, G3 = 6.12. The inverted-U holds across TFD and average fixation depth. Between BFS and DFS, only G1 differs significantly (p = .040, r = .43); G2 and G3 do not, suggesting prior knowledge overrides the algorithm's visual structure.

### 4.2 Monotonic substitution with expertise

At the participant level (averaging each participant's BFS and DFS trials), the Spearman correlation between pseudocode and map TFD gets more negative as expertise grows: G1 r = -.03 (ns, n = 19), G2 r = -.46 (p = .04, n = 21), G3 r = -.63 (p = .003, n = 20). Fisher z supports the endpoint contrast (G1 vs G3 p = .04); the adjacent contrasts do not reach significance on their own (G1 vs G2 p = .18, G2 vs G3 p = .47). People who dwell longer on one panel dwell proportionally less on the other, and that trade-off steepens with expertise.

Fixation count shows the same direction but weaker: G1 r = +.04, G2 r = +.33, G3 r = -.16, all non-significant; pairwise Fisher z on FC is also non-significant (G2 vs G3 p = .13; G1 vs G3 p = .55; G1 vs G2 p = .38). See Figure 1. Partial Spearman controlling for group and algorithm gave similar directional results.

The TFD pattern matches what ERE predicts. Novices attend both panels independently, intermediates start to trade dwell time between them, and experts trade off most strongly. Dwell becomes a zero-sum allocation as the schema develops; the coordination CTML predicts from a dual-channel format does not show up in any group's dwell data.

### 4.3 Attentional coupling

Attentional coupling rises with expertise. Mean absolute Spearman r across all metric pairs: G1 = .294, G2 = .330, G3 = .369. Novices show the most independent metrics. The ratio-to-scanner-index pair, for example, moves from r = -.04 in G1 to r = -.67 in G3.

---

## 5. Discussion

### 5.1 Mechanism

The monotonic strengthening of negative TFD correlation follows from CLT and ERE across the three groups.

G1 has no schema. Working memory is occupied by a novel algorithm and a novel visual format, so dwell on each panel is largely independent of dwell on the other.

G2 has a partial schema. Predictable steps can be read from one panel alone, so dwell on one begins to offset dwell on the other. The positive directional trend in fixation count suggests that confirmatory visits stay frequent even as dwell times start to trade off.

G3 has internalized the algorithm. Either panel is enough to anticipate the next step, so time spent on one is time that does not need to be spent on the other.

The inverted-U in pseudocode-to-map ratio (§4.1) and the monotonic substitution in dwell time (§4.2) are the same mechanism at two scales: overall attention allocation and moment-to-moment dwell trade-offs.

### 5.2 Design Implications

The substitution gradient means each expertise group uses the split-panel design differently. G1: panels are independent, and scaffolding (line highlights, annotations, staged display) may be needed to promote coordination. G2: partial substitution while still engaging both panels, which is the profile the split-panel format fits best. G3: the pseudocode panel is a verification check, and either representation alone would likely suffice.

Attention metrics pooled across expertise levels yield averages that describe none of the groups accurately.

### 5.3 Limitations

Roughly five of the 105 Fisher z tests would reach p < .05 by chance alone. The primary TFD contrast (G1 vs G3, p = .04) survives that threshold even under modest correction. The FC sign reversal is directional rather than inferential at the participant level. Expertise groups were not randomized, so differences may reflect general ability or motivation. All visualizations used the Metal style. Group sizes of 19–21 limit power for smaller effects.

### 5.4 Conclusion

Pseudocode and map dwell times trade off more strongly as programming expertise grows. Novices attend both panels independently; intermediate and experienced viewers increasingly substitute one for the other. Layouts validated at one expertise level may not generalize, and pooling across levels can hide this substitution gradient.
