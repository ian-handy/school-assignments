# Paper Draft - Dual Engagement Reversal in Algorithm Visualization

Razieh Fathi, Ian Handy

---

## TITLE

Dual-Representation Engagement and Expertise: An Eye-Tracking Study of Pseudocode and Geospatial Maps for BFS and DFS Algorithm Visualizations

---

## ABSTRACT

In this paper we investigated how participants' (n = 62) across three different levels of programming experience engaged with pseudocode and geospatial maps as their respective visual representations during BFS and DFS animation videos. We employed an eye-tracker at 60 Hz to record participants' eye movements. Previous research on multi-modal learning suggests that users will engage all provided visual representations simultaneously, however our results demonstrate that this occurs in only one of the three levels of user expertise. In the intermediate group (G2), there was a positive correlation between the number of times participants looked at the pseudocode list and the number of times they looked at the geospatial map. Conversely, there was little to no relationship observed in either the low-experience group (G1) or the high-experience group (G3). Thus, split-panel algorithm visualization designs seem to be effective for only one of three possible target audiences.

---

## 1. Introduction

Research has demonstrated that the use of multi-modal presentations can enhance student performance in terms of problem-solving and other forms of learning [Mayer 2001], although the impact of multi-modal communications appears to vary depending upon the individual learner's prior experience with related topics. This study builds upon the theoretical frameworks outlined in the Expertise Reversal Effect [Kalyuga 2003, Sweller 1988] and Cognitive Load Theory [Sweller 1988]. These models provide an empirical framework for predicting the type(s) of learners for whom multi-modal communications are likely to produce improved learning outcomes. Research has also shown that multi-modal communications can result in varying degrees of engagement among different types of learners. For example, previous research has failed to identify the extent to which learners using multiple representations tend to coordinate their engagement across representations. Therefore, this study addresses this gap by determining whether coordination between a pseudocode list and a geospatial map is consistent across different levels of learner expertise. If coordination varies by level of expertise, then it would suggest that some learners benefit more than others from multi-modal communications. Additionally, previous research has focused primarily on transition counts or fixation timing between representations rather than examining the relationships between representations. Since the sign reversal required by this research question can only be identified via a measure of association (i.e., correlation), we utilize Spearman correlations to examine the relationships between pseudocode list fixations and geospatial map fixations. Our primary contributions are: (1) evidence that demonstrates a sign reversal in dual-panel fixation correlation across expertise levels, (2) an operational definition of dual-representation engagement based on correlation, and (3) design implications for creating algorithm visualizations based on user expertise level.

---

## 2. Related Work

As stated earlier, Mayer's Cognitive Theory of Multimedia Learning (CTML) states that presenting verbal and pictorial information through separate processing channels enhances learning due to increased efficiency in integrating information into working memory [Mayer 2001]. Direct application of this theory is evident in split-panel algorithm visualizations where both verbal and pictorial representations are presented side-by-side.

Working Memory Capacity is limited; thus, an additional representation will increase cognitive load for novice learners. As described by Sweller's Cognitive Load Theory, the additional representation will create additional cognitive load. Furthermore, Sweller theorized that when the intrinsic load associated with a topic is sufficiently high, adding another representation can cause greater harm than good [Sweller 1988, 1994]. Novice learners will have a new algorithm and a new visual format to learn simultaneously.

According to Kalyuga et al., as learners gain knowledge, previously helpful instructional aids can become redundant or even detrimental [Kalyuga et al. 2003]. Learners developing a schema for a new algorithm benefit from labeled pseudocode representing each step. Learners who already know an algorithm do not require those labels. Both of these theories state that reliance on pseudocode should decrease monotonically from novice (G1) to expert (G3). However, neither theory provides insight into why there might be a reversal in direction at G2.

Gegenfurtner et al. conducted a meta-analysis of 296 eye-tracking studies and reported that intermediate learners exhibit longer fixation duration than both novices and experts [Gegenfurtner et al. 2011]. This finding is counterintuitive given the typical "novice-to-expert" framing for the progression from novice to expert. 

Bednarik evaluated learners' attentional strategies while debugging source code with multiple representations and discovered that experts and novices employ distinct attentional strategies [Bednarik 2012]. While experts consult secondary representations to confirm existing mental models, novices alternate between panels without a guiding strategy. Our investigation includes Bednarik's excluded intermediate group.

Richter and Scheiter measured process-level eye-movements toward both text and picture AOIs in multimedia learning tasks among two levels of prior knowledge [Richter and Scheiter 2019]. When signaling cues were available, low-prior-knowledge learners exhibited coordination between both AOIs; high-prior-knowledge learners did not derive benefit. The experimental design shared structural similarities with our study's pseudocode and geospatial map AOI setup. Neither Bednarik nor Richter & Scheiter included multiple groups or utilized correlation structures as units of measurement. The sign reversal required by this study necessitates both.

## 3. STUDY DESIGN

### 3.1 Participants and Design

We recruited 117 participants who wore an eye-tracker to record their viewing of animated visualizations of algorithms. We categorized the participants according to their prior experience: no prior programming experience (n=38); brief prior programming experience (n=39); multiple years of formal programming education (n=40). Each participant viewed either a BFS visualization (n=59) or a DFS visualization (n=58). All participants viewed animations created with Metal.

### 3.2 Visualizations

Both panels were always shown to participants throughout the experiment. One panel contained pseudocode. A second panel contained a geospatial representation showing the nodes and edges where the algorithm activates nodes when it visits them.

### 3.3 Eye-Tracker Metrics

There were two Areas of Interest (AOIs): the pseudocode panel and the geospatial map panel. Two eye-tracking metrics were examined: the number of times a person fixated on each panel (fixation count), and the total amount of time spent looking at each panel (total fixation duration).

Three derived metrics were computed:

* The pseudocode-to-map ratio (the ratio of the total fixation duration in the pseudocode panel to the total fixation duration in the geospatial map panel).
* Scanner Index (Total fixation duration in the pseudocode panel/Total fixation duration in the pseudocode panel).
* Average fixation depth (total fixation duration in the pseudocode panel/Fixation count in the pseudocode panel).
* Switching Rate ((scanner index in the pseudocode panel + scanner index in the geospatial map panel)/(total fixation duration in the pseudocode panel + total fixation duration in the geospatial map panel)).

### 3.4 Statistics

Since we have non-normal data, since we are dealing with eye tracking data, and since our group sizes are small, we use nonparametric statistics. For comparing group means, we use Kruskall-Wallis H with pairwise Mann-Whitney U post hoc tests. To examine correlations within each group, we used Spearman R. To evaluate if there is a difference in the correlation structures among the groups, we employed Fisher Z transformation. This allows us to test if the Spearman R between two variables is different among groups. Lastly, we evaluated partial Spearman correlation with respect to group membership and algorithm type.

---

## 4. Results

### 4.1 Non-monotonic relationship between pseudocode engagement and prior knowledge

Our results suggest that individuals who had previous experience with the topic (i.e., G2), looked at the pseudocode panel longer than both novices (G1) and experts (G3). Specifically, G2 exhibited a higher median ratio of pseudocode to map (Mdn = 12.33) compared to G1 (Mdn = 9.57) and G3 (Mdn = 6.12). This inverted-U effect held true across TFD and average fixation depth measures.

In terms of pseudocode-to-map ratios between the two search conditions, only G1 exhibited a statistically significant difference (p = .040; r = .43) between the two search types, while G2 and G3 did not exhibit such effects, indicating that prior knowledge may dominate over visual aspects of an algorithm.

### 4.2 Change in dual engagement patterns

Correlation trends for fixation counts differed among groups. While G2 exhibited positive correlation trends (r = +.32; p = .05), G3 exhibited a reverse pattern (r = -.28; p = Ns) and G1 exhibited no trend (r = -.02; p = Ns). [See Figure 1]

Using Fisher Z-test, we confirmed that these group differences in correlation trends are statistically significant (p < .01). Furthermore, this trend was consistent for both BFS and DFS conditions separately, thus eliminating confounding due to visual search strategies. Controlling for group membership and search strategy using partial Spearman correlation produced similar results. When replacing fixation count with total fixation duration, we also observed the same pattern. [See Figure 3]

It appears that G2 exhibits greater simultaneous engagement of both panels, reflecting what should occur during dual-channel processing according to CTML. According to our findings, however, active dual-channel processing occurs only at one level of expertise.

### 4.3 Attentional Coupling

We observed a monotonic increase in attentional coupling as a function of increasing expertise level. The mean absolute Spearman R values across all possible combinations of metrics were .294 for G1,.330 for G2, and .369 for G3. As a consequence, those individuals with little familiarity with the material exhibited uncorrelated metrics. For example, whereas the ratio-to-scanner_index pair exhibited a Spearman R value of -.04 in G1, it exhibited a value of -.67 in G3.

## 5. DISCUSSION

### 5.1 Mechanism

The sign reversal observed in Section 4.2 results directly from the interaction of the Central Limit Theorem (CLT) and Expected Relative Error (ERE), occurring over the three groups.

G1 students had no prior schema of either BFS or DFS. Working memory was simultaneously devoted to an unfamiliar algorithmic representation, and an unfamiliar visual representation. Due to the lack of a schema that could bind the two panels together, fixations on each panel occurred independently of the other.

G2 students had a partial schema. They recognized that the pseudocode, and the map illustrated the same process but from opposite perspectives. Although their intrinsic load decreased sufficiently to allow sufficient working memory capacity, they could still read a line of code, verify the appropriate node on the map, and then go back to reading the next line. The support provided by each panel for the other produced a positive relationship.

G3 students had developed an internalized version of the algorithm. Whether they viewed either panel would give them enough information to determine what came next. Once they consulted both panels it became redundant to consult them again because viewing one panel diminished the necessity of consulting the second panel. This generated a negative relationship.

Both the U-shaped function representing the amount of pseudocode relative to map (Section 4.1) and the sign inversion in dual engagement (Section 4.2) illustrate the same mechanism at two scales: overall attention, and moment-by-moment coordination.

### 5.2 Design Implications

Although fixations and visits do not necessarily represent active engagement with the subject matter, G2 has apparently justified a split-panel design for the visualization. In contrast to G1 who were not using the pseudocode panel productively, G1 students may require scaffolds like highlighted lines, comments, or progressive disclosure to utilize the pseudocode panel effectively before presenting both panels simultaneously. On the contrary, for G3 students, the pseudocode panel serves as a rapid verification check rather than a primary source of information.

Additionally, our data indicates that whether or not students actively attend to aspects of an algorithm while engaged in learning is more influenced by how much students know about algorithms than by their experience using algorithms. As a result, attention metrics analyzed without distinguishing between levels of expertise will yield average values that are applicable to none of the populations studied here.

### 5.3 Limitations

With approximately 105 statistical tests run in our Fisher Z-test battery, we expect approximately five Type I errors due to chance at a significance level of p < .05. Our most significant finding in Section 4.2 is found at p = .009, thus our result is well within this range. We did not randomly assign participants into our expertise groups; therefore, observed differences among expertise groups may reflect differences based upon ability or motivation generally rather than knowledge of programming specifically. Since all visualizations employed the Metal style, we cannot generalize our results to alternative styles of animations. While group sizes of about nineteen through twenty subjects per group provide some power to detect small differences in correlations among these groups, we acknowledge that this limits our ability to observe larger differences among groups.

### 5.4 Conclusion

There is little evidence to suggest that students at varying levels of expertise engage equally when presented with dual-panel representations of algorithms. Coordinated engagement patterns similar to those intended with split-panel formats occur only at intermediate levels of student knowledge; novice students and expert students do not exhibit this type of engagement. Therefore, designers seeking to create a specific visual representation for a particular level of expertise should not assume that validation of a given representation based upon a sample of students at one level will also apply to samples drawn from different levels. Additionally, researchers attempting to study student use across multiple levels of expertise should be aware that pooling data across these levels may mask distinct characteristics among student subpopulations.
