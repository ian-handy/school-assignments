# Fathi 2022 Eye-Tracking Study — Plain-Language Explainer

---

## What this study is about

Researchers built three different animated visualizations of two graph-traversal algorithms — **BFS** (Breadth-First Search) and **DFS** (Depth-First Search) — and had participants watch them while wearing an eye-tracker. The goal: figure out whether the *look* of the animation changes where people spend their attention.

Every visualization had two panels side-by-side:
- **Left panel: Pseudocode** — a line-by-line code listing of the algorithm
- **Right panel: Geospatial Map** — a visual graph where nodes light up as the algorithm visits them

The three visual styles were:
- **IRN** — geospatially realistic node layout
- **Galles** — clean, textbook-style node layout
- **Metal** — high-contrast, stylized rendering

---

## What eye-tracking measures

An eye-tracker records where on the screen your eyes are pointing ~60 times per second. From that raw stream it extracts **fixations** — moments where your eyes hold still on something (usually 100–400ms). Fixations are how we measure *attention*.

The key metrics in this dataset:

| Metric | What it means |
|---|---|
| **Total Fixation Duration (TFD)** | How many seconds total did this person stare at this region? |
| **Fixation Count (FC)** | How many individual fixations landed in this region? |
| **Time to First Fixation (TTFF)** | How long after the trial started did they *first* look at this region? |

These are collected per **AOI (Area of Interest)** — a rectangle drawn over part of the screen. The AOIs here are: **Pseudocode**, **Geospatial Map**, **Queue**, **Stack**.

---

## The Queue AOI — why it matters

The Queue is a first-in, first-out list that BFS uses to track which nodes to visit next. It's not the flashy part of the visualization — it's a small data structure display. But it's mechanistically important: it's *where the algorithm lives* between steps.

The hypothesis is: someone who is actually *reading and following* the pseudocode should also glance at the Queue to check the current state of the algorithm. Someone who is just watching the graph light up has no reason to look at the Queue at all.

So **Queue fixation count** is used as a behavioral marker for "this person is processing the algorithm procedurally, not just watching."

---

## The core analysis: pseudocode/map attention ratio

The main derived metric is:

```
ratio = TFD_pseudocode / TFD_map
```

- **ratio > 1** → spent more time reading the code than watching the graph
- **ratio < 1** → spent more time on the graph
- **ratio = 1** → even split

The question is: does a richer, more visually striking animation (Metal) produce a *lower* ratio than a plain one (Galles)? If yes, it means the visual design is pulling attention away from the code — a "split-attention effect."

---

## What the data cleaning actually fixed

### Problem 1: Tobii appends summary rows to each file
Tobii Studio exports the data with rows for each participant, then adds extra rows at the bottom for `Mean`, `Sum`, `Std`. If you just read the file and loop over rows, those fake rows get treated as participants. Fix: drop any row where the participant name is a stat keyword.

### Problem 2: AOI columns have generic names
Tobii names the AOIs whatever shape they are — `Rectangle`, `Rectangle 2` — not what they represent. We have to map `Rectangle → Pseudocode` and `Rectangle 2 → Map` based on knowing the study layout. If this mapping is wrong, everything downstream is wrong (this is flagged as a limitation).

### Problem 3: Two TFD variants exported ("Include Zeros" and not)
Tobii gives you TFD both including and excluding participants who never looked at the AOI. We want the *excluding zeros* version — including zeros would deflate the mean for people who actually looked, since participants who never looked drag the average down.

### Problem 4: Division by zero in the ratio
A participant who literally never looked at the map would produce `tfd_map = 0`, and dividing by 0 gives infinity. Instead of dropping these participants, we add a tiny epsilon (`1e-9`) to the denominator. The ratio is still enormous (meaning: all pseudocode, no map), but it's finite. Participants with a ratio > 25 are flagged as potential outliers.

### Problem 5: IRN data is in a completely different format
Galles and Metal groups were exported as per-participant summary XLS files. IRN was exported as a raw gaze-sample TSV — one row per 60Hz sample, not per participant. We have to identify fixation events ourselves (filter to `GazeEventType == Fixation`), collapse each fixation to a single row, and then aggregate to per-participant totals. This is the only format that includes Queue AOI data.

---

## What the analysis pipeline does, step by step

1. **Load all XLS files** → one row per participant per condition, with AOI metrics
2. **Load the IRN TSV** → parse raw samples into fixations into per-participant summaries
3. **Compute the ratio** for each participant
4. **Descriptive stats** → just look at distributions before testing anything
5. **Mann-Whitney U test** → compare Galles vs Metal ratios (non-parametric because n ≈ 7–10 per cell)
6. **BFS vs DFS comparison** → does the algorithm type also affect the ratio, within each style?
7. **Spearman correlation** → does a higher ratio predict more Queue fixations? (IRN only)
8. **Correlation matrix** → exploratory — which metrics correlate with each other across the whole dataset?

---

## What the findings might mean

If Metal produces a **lower ratio** than Galles:
> The more stylized, visually rich animation draws the eye away from the pseudocode. This is a design failure if you want students to actually read the code — they're just watching the animation.

If BFS produces a **higher ratio** than DFS:
> BFS's wave expansion pattern is harder to visually track (it spreads in all directions), so viewers consult the pseudocode more to orient themselves. DFS follows a clear path you can just watch. This would mean BFS visualizations need *more* scaffolding on the pseudocode side, not less.

If pseudo/map ratio **positively correlates with queue fixations**:
> People who read the code also check the queue — they're running the algorithm in their head step by step. People who watch the graph skip the queue entirely. This gives you a behavioral signature for "deep processing vs. surface watching."

---

## The bigger research question

All of this points toward: **how do you design algorithm visualizations that actually teach?** If a flashy visualization makes students watch instead of read, and watching doesn't produce the same comprehension as reading, then better-looking ≠ better for learning. The study can't fully answer that (there's no comprehension test), but the attention patterns are a first step toward knowing whether design choices matter at all.
