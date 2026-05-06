# Sentence Workshop

*Rewrite each sentence in your own words. Technical notes are there so you don't lose accuracy.*

---

### 1 — The hook (Introduction, sentence 1)

**Casual version:**
People who make algorithm teaching tools assume that showing pseudocode next to an animation is automatically helpful.

**Technical info you need:**

- This assumption comes from CTML (Mayer 2001) — dual channels, verbal + visual, combined = better
- It's the standard justification for split-panel algorithm visualizations
- Your paper challenges whether it's universally true

**Your version:**

> Previous studies (CTML Mayer 2001) have suggested that multi-channel communication leads to higher engagement.

---

### 2 — Why the assumption breaks down (Introduction)

**Casual version:**
Whether using two panels at once actually helps depends entirely on how much the viewer already knows.

**Technical info you need:**

- Expertise Reversal Effect (Kalyuga et al. 2003): scaffolds that help novices can hurt experts
- Cognitive Load Theory (Sweller 1988): working memory is limited; more representations = more load
- The two together predict a non-linear effect across expertise levels

**Your version:**

> The multi-channel approach seems to affect engagement non-linearly in relation to previous experience. The research extends upon the Expertise Reversal Effect and Cognitive Load Theory and, with further studies, could help indicate the outer bounds of when these approaches are most suitable.

---

### 3 — What prior studies missed (Related Work)

**Casual version:**
Previous eye-tracking studies on this mostly just counted how many times people switched between panels — they never asked whether the two panels were moving together or against each other.

**Technical info you need:**

- Prior work measured coordination via transition counts or fixation timing (e.g., Bednarik 2012, Richter & Scheiter 2019)
- This study uses Spearman correlation between fc_pseudo and fc_map as the unit of measurement
- That's what lets you see the sign reversal — transitions can't tell you direction

**Your version:**

> There have been numerous studies relying on eye tracking data, but the focus of such studies is usually on the transition counts or fixation timing, not the directionality of the movement.

---

### 4 — The inverted-U (Findings 4.1, sentence 1)

**Casual version:**
Intermediates spent the most time reading the pseudocode — not because they were slow, but because they were at the one expertise level where the code was actually useful to them.

**Technical info you need:**

- Median ratio: G1 = 9.57, G2 = 12.33, G3 = 6.12 (pseudocode TFD / map TFD)
- Inverted-U: G2 peaks, G1 and G3 both lower
- G1 can't parse the code efficiently; G3 already knows the algorithm and barely needs it

**Your version:**

> Our study seems to suggest that participants who had some exposure to the subject matter (G2) were likely to engage with it for notably longer than G1 and G3.

---

### 5 — Algorithm sensitivity disappears with expertise (Findings 4.1)

**Casual version:**
Novices look at completely different things depending on whether they're watching BFS or DFS. Experts don't — they already know what to expect from both.

**Technical info you need:**

- BFS vs DFS gap in ratio: significant in G1 (p=.040, r=0.43), gone in G2 (p=.60), gone in G3 (p=1.00)
- BFS: broad wave expansion, visually confusing → novices consult pseudocode early
- DFS: single path, easy to follow → novices stay on the map
- G2 and G3 override the visual pull with prior knowledge

**Your version:**

> The gap between BFS and DFS in G1's fixation counts are an anomoly that subsides in G2 and further subsides in G3.

---

### 6 — The main finding in one sentence (Findings 4.2)

**Casual version:**
Intermediate learners are the only group where looking at the code more also means looking at the map more — for everyone else, one goes up and the other goes down.

**Technical info you need:**

- G1: r = −0.018, p = ns (no relationship)
- G2: r = +0.317, p = .049 (positive — both panels go up together)
- G3: r = −0.276, p = ns (negative trend — trade-off)
- Fisher z-test confirms group differences are significant: p = .009
- Holds within BFS and DFS separately; survives partial correlation controls

**Your version:**

> Fixation count correlation trends positively in G2, contrasting against the negative trend of G3 and the absence of a trend in G1.

---

### 7 — What the G2 pattern actually means (Findings 4.2, mechanism)

**Casual version:**
When G2 viewers are doing this, they're reading a line of code, checking it against the graph, going back to the code for the next line — actually using both panels together in real time, which is exactly what the visualization is supposed to make people do.

**Technical info you need:**

- This is the dual-coding signature: genuine parallel engagement with two representations
- CTML calls this "integrating corresponding words and pictures" — the active process that drives multimedia learning gains
- G1 doesn't have the schema to do this; G3 doesn't need to

**Your version:**

> The direct engagement of G2 with the pseudocode and the graphics suggests that they are the group most likely to observe all relevant content that occupies display real estate.

---

### 8 — G3's trade-off behavior (Findings 4.2, mechanism)

**Casual version:**
Experts use the two panels as substitutes — once they've gotten what they need from one, they don't bother with the other.

**Technical info you need:**

- Negative trend in G3: r = −0.276
- Interpretation: automated schema means one panel is sufficient to confirm what they already know
- They're not ignoring the other panel — they're strategically not needing it
- This is the ERE in action: the redundancy effect

**Your version:**

> G3's observational trends suggest that they are less likely to spend significant time looking at sections of the screen outside of their preferred fixation. 

---

### 9 — The coupling finding (Findings 4.3)

**Casual version:**
As people get more experienced, all their eye-tracking metrics start moving together — knowing one thing about how they look predicts everything else about how they look. For beginners, each metric is basically independent.

**Technical info you need:**

- Mean absolute Spearman r across all metric pairs: G1 = 0.294, G2 = 0.330, G3 = 0.369 (monotonic increase)
- Example: ratio ↔ scanner_index goes from r = −0.04 (G1) to r = −0.67 (G3)
- Interpretation: expertise reorganizes the whole attention system, not just individual metrics
- Methodological implication: pooling expertise levels in eye-tracking studies produces averages that don't reflect any individual's actual behavior

**Your version:**

> Our study suggests a monotonic increase across all metric pairs with experience. Those participants less experienced with the subject matter were more likely to show independent metrics.

### 10 — The design punchline (Discussion 5.2)

**Casual version:**
The split-panel layout with pseudocode and animation side by side is essentially built for the intermediate learner. Beginners need more help than it gives them; experts don't need it at all.

**Technical info you need:**

- G1 needs: annotated pseudocode, line highlights, natural language, or delayed simultaneous display
- G2: current design works as intended
- G3: pseudocode panel may be unnecessary overhead
- Practical recommendation: visualizations should adapt to or target a specific expertise level, not assume one design works for all three

**Your version:**

> While fixations and visits do not inherently equate to active engagement with the material, G2 seems to, at least, have justified the split window design of the demonstration.

---
