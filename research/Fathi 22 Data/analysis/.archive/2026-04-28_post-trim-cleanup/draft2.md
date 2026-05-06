## Pseudocode-Map Substitution Grows with Expertise

Razieh Fathi, Ian Handy

## Abstract

This study examined how novice and experienced programmers attended to Pseudocode and maps presented simultaneously while viewing video tutorials about breadth-first search (BFS) and depth-first search (DFS) graph traversals. Using eye tracking technology, we recorded where each of our 62 participants directed their gaze toward the Pseudocode or the Map during each of the 117 trials they completed. As programming knowledge increased from novice to intermediate to advanced, the correlations between how much time was spent gazing at the Pseudocode versus the Map became significantly more negative. This represents a type of Expertise Reversal Effect. While there was a similar trend in terms of how many times each area of interest was viewed, the trend did not reach statistical significance. Therefore, although these findings support the idea that a design intended to be optimal for novice learners might be suboptimal for expert learners, they also suggest caution regarding generalizing results based upon findings obtained from a limited number of novice learners.

---

## 1. Introduction

The ability to combine multiple representations has been shown to enhance learning [Mayer 2001]. However, the extent to which such combinations are effective will depend upon the prior experiences of those who receive instruction. Both Cognitive Load Theory (CLT) [Sweller 1988] and the Expertise Reversal Effect (ERE) [Kalyuga 2003] propose that instructional aids, which are beneficial for novices, do not provide additional benefits for experienced learners. CLT states that the primary source of cognitive load is due to the complexity of the content being learned. When an experienced learner receives instruction via an aid designed for novices, ERE suggests that the added load created by the aid will outweigh its potential benefits. ERE proposes that as learners gain experience and form a schema related to the subject matter being taught, aids that previously supported the learning process become unnecessary.
Therefore, in order to determine whether such a trade-off occurs and whether the trade-off varies depending upon the level of expertise of a given learner, we calculated the Spearman correlation coefficient between the total amount of time spent gazing at the Pseudocode and the total amount of time spent gazing at the Map. These calculations allowed us to assess the degree to which learners substituted one representation for another.

Contributions: (1) we found significant evidence that the amount of time experienced learners spend gazing at Pseudocode and/or a Map decreases as they begin to substitute one for the other; (2) we provided a correlation-based method for quantifying representation substitution; and (3) we suggested implications for designing split-panel visualizations that cater specifically to certain levels of expertise.

---

## 2. Literature review

CTML (Cognitive Theory of Multimedia Learning), developed by Mayer [Mayer 2001], posits that presenting verbal and pictorial information via separate pathways into working memory allows for better integration than when both types of information are combined. Visualizations involving split panels apply this concept directly to the presentation of algorithms. CLT provides a theoretical basis for understanding why adding a second representation to an existing representation would increase cognitive load. Specifically, CLT states that when the intrinsic difficulty of a task is already high, a secondary representation will result in greater cognitive load than a single representation [Sweller 1988, 1994]. Finally, ERE expands on CLT by proposing that instructional aids that assist novices become redundant once learners have formed a schema related to the subject matter being studied [Kalyuga 2003].
A meta-analysis conducted by Gegenfurtner [Gegenfurtner 2011] revealed that intermediate learners tend to focus more than both novice and expert learners, which challenges the traditional view that as prior knowledge increases so too does focused attention. Bednarik [Bednarik 2012] demonstrated that experts and novices differ in their attentional strategies when debugging algorithms. Experts verify their mental models whereas novices oscillate back-and-forth between panels without relying upon a strategic approach to problem solving. Similarly, Richter & Scheiter [Richter & Scheiter 2019] discovered that low-prior-knowledge learners use signals to coordinate text and picture areas-of-interest (AOI) when providing cues; however, high-prior-knowledge learners do not benefit from cues.
Neither Bednarik nor Richter & Scheiter tested three levels of expertise. Furthermore, neither study measured correlation between dwell times as a metric. To demonstrate a substitution gradient requires both measures.

## 3. Methods

### 3.1 Subjects

Sixty-two subjects participated in this experiment. They all wore a Tobii eye tracker set to capture data at 60 Hz while watching animated versions of both BFS and DFS algorithmic visualizations. Prior knowledge was categorized into three levels: none (novice), brief (intermediate), years of formal coursework (expert). In addition, each participant received both algorithms, resulting in 117 trials (59 BFS, 58 DFS) after quality control checks were performed. The animation format for all stimuli was the Metal style.

### 3.2 Stimuli/AOIs

Each trial consisted of a split-screen stimulus showing Pseudocode on the left and a geospatial Map (with nodes/edges lighting-up as they were traversed by the algorithm) on the right. Two AOIs were defined: Pseudocode and Map. two primary metrics were collected: Fixation Count (FC) and Total Fixation Duration (TFD). Derived metrics: Pseudocode-to-Map TFD ratio (TFD_pseudo / TFD_map), scanner index (VC_pseudo / TFD_pseudo), average fixation depth (TFD_pseudo / FC_pseudo), and switching rate ((VC_pseudo + VC_map) / (TFD_pseudo + TFD_map)).

## **4. Results**

### **4.1 A Non-Monotonic Pattern Of Engagement In Pseudocode**

G2 viewed the pseudocode panel longer than G1 and G3. The median pseudocode-to-map ratio was 12.33 in G2. G1 and G3 showed medians of 9.57 and 6.12 respectively. This represents an inverse U relationship with respect to both Total Fixation Duration (TFD) and average fixation depth. Only G1 was different (p=.040) when comparing BFS and DFS. However, there was no difference (p>.50) when comparing G2 and G3. Thus, prior knowledge appears to override the impact of visual organization in determining where participants allocate their gaze.

### **4.2 Monotonic Substitution With Respect To Expertise**

As expertise increased, the Spearman rank order correlation coefficient (rho) between pseudocode view TFD and map view TFD became more negative. rho(G1)=-.034, NS, n=19; rho(G2)= -.457, p<.050, n=21; rho(G3)= -.631, p=.003, n=20. Fisher Z supported the end point comparison (G1vsG3, p<.050); however, neither of the middle comparisons reached statistical significance (G1vsG2, p=.180; G2vsG3,p=.470).

Similarly, the rank order correlation between pseudocode view fixation count and map view fixation count followed the same trend but had lower values. rho(G1)=+.042, NS; rho(G2)=+.326, NS; rho(G3)= -.161, NS. All three correlations failed to reach statistical significance (p>0.100). Similarly, pairwise Fisher Z on FC failed to reach significance (p > .10): G2 vs G3 (p = .130); G1 vs G3 (p = .550); G1 vs G2 (p = .380). Refer to Figure 1. Partial Spearman controlling for group and algorithm yielded directional relationships similar to those found for TFD.

The TFD findings match the predictions of ERE regarding visual search behavior. Novices use both panels as separate units of information processing space; intermediates begin to substitute one unit for another; and experts substitute most heavily. As a result, time devoted to viewing one unit becomes time that is subtracted from viewing another unit. The predicted coordination effect of CTML due to the dual channel nature of the layout is absent in every group's dwell time measures.

### **4.3 Attentional Coupling Increases With Increasing Expertise**

Attentional coupling increases with increasing expertise. The mean absolute value of Spearman's rank order correlation coefficient (rho) across all possible metric pairs: G1 = .294; G2 = .330; G3 = .369. Participants without prior experience with visual representations of algorithms demonstrated the least coupled metric pairs. For example, the ratio to scanner index pair ranged from - .04 in G1 to - .67 in G3.

---

## **5. Discussion**

### **5.1 Mechanisms**

There is evidence consistent with CLT and ERE in support of a monotonic increase in the magnitude of negative correlation in TFD as expertise increases among the three groups.

G1 had no schema. Memory usage for working memory is consumed by learning a new algorithm and learning a new format for visualizing that algorithm. Therefore, dwell time for each view is generally unrelated to dwell time for the other view.

G2 had a partial schema. There are predictable steps available for reading from each individual panel separately, therefore, dwell time on one view begins to inversely relate to dwell time on the other view. The positive trend observed in fixation counts indicates that although confirmatory visits occur frequently as individuals develop expertise with a particular problem domain, this coordination weakens as dwell times become more interdependent between panels.

G3 has learned the algorithm. Each panel provides sufficient predictive information about the next action required for solving the task. Therefore, dwell time for one view reduces dwell time for the other view.

Both the inverted-U curve for the total dwell time ratio between pseudocode and map views (Section 4.1) and the monotonic relationship for substitution in terms of dwell time (Section 4.2) represent the same process at two different levels: overall attentional distribution and moment-by-moment dwell trade-offs.

### **5.2 Design Implications**

Since substitution varies with respect to expertise level, each group of learners uses the split-panel design differently than others. G1: Both panels are used independently. Scaffolding (e.g., line highlighting, annotation, staged display) may be necessary to facilitate coordination between panels.

G2: Panels are partially substitutable with respect to each other while still being engaged simultaneously. This profile fits well with the split-panel format.

G3: The pseudocode panel serves as a verification check for either representation alone.

Metrics related to attention aggregated across all levels of expertise provide average values that characterize none of the groups accurately.

### **5.3 Limitations**

It is expected that roughly five of the 105 Fisher Z tests would reach p<.05 by chance alone. While the main TFD contrast (G1 vs G3, p=.04) survives that threshold with some modest correction applied, neither of the FC sign reversals reached statistical significance at the participant level. Learner expertise groups were not randomly assigned, thus group-level differences may be reflective of either general cognitive ability or learner motivation. All visualizations utilized Metal style. Group sizes of 19-21 limited power for detecting small effects.

### **5.4 Conclusion**

Time allocated to viewing pseudocode versus maps trades off positively with programming expertise level. Time allocations are essentially independent for novice programmers; intermediate and advanced programmers substitute one for the other increasingly with greater expertise level. Layouts validated at one level of expertise may not generalize; aggregating attentional metrics across levels of expertise hides this substitution gradient.
