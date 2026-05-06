# Beginner Distraction Analysis — Plain-Language Explainer

---

## What this notebook asks

The main analysis (`fathi_analysis_skeleton.ipynb`) established that visualization style *might* shift attention away from pseudocode. This notebook asks a follow-up: **does that effect only hit people who are new to programming?**

The logic: an experienced programmer knows to look at the pseudocode regardless of how pretty the animation is — they've trained themselves to read code. A beginner has no such habit. If the visualization is flashy enough, a beginner might just watch the lights and skip the code entirely. An expert would read the code no matter what.

If this is true, it's a much more specific and actionable finding: you don't need to redesign visualizations for everyone, just for novices.

---

## What "expertise" means here

The ideal measure of expertise is a **pre-study survey**: We are using graduation year here

---

## What the three charts show

**Chart 1 — Bar chart by style and experience:**
Is the Galles–Metal gap in pseudocode attention bigger for novices than experts? If the bars look very different for novices but similar for experts, the effect is expertise-specific.

**Chart 2 — Interaction plot:**
Two lines, one per experience group, plotted across Galles and Metal. If the lines cross or have very different slopes, it means experience moderates the style effect — the classic signature of a moderation finding.

**Chart 3 — Time to first fixation:**
Does it take novices longer to *first* look at the pseudocode in Metal? If yes, the rich animation is capturing their attention at the very start of the trial — before they've even oriented to the code. This is the strongest form of the distraction effect.

---

## Files in this folder

| File                           | Contents                                                            |
| ------------------------------ | ------------------------------------------------------------------- |
| `beginner_distraction.ipynb` | Analysis notebook — runs on the same XLS data as the main skeleton |
| `ideas_list.md`              | One-sentence research question this folder addresses                |
| `participants.md`            | Transcribed participant list with missing-data annotations          |
| `explanation.md`             | This file                                                           |
