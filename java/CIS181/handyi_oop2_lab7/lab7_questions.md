# Lab 7 Questions

**Step 8: Rerun both Streamer.java and Cumbersome.java with numbers150.txt instead of numbers15.txt. Does anything look... not right with the output? What is glaringly wrong with the output, and what do you think is the reason for it?**

The "Product" line is the glaringly wrong one. With numbers15.txt I get `Product: 1382400`, which is a sensible number. With numbers150.txt I get `Product: 0` even though every value being multiplied is non-zero (the filter excludes zeros). A product of non-zero integers can never actually be zero, so something has clearly gone sideways.

The reason is integer overflow. A Java `int` is a 32-bit signed value with a range of about ±2.1 billion. Multiplying ~150 non-zero numbers together — many of them with magnitude up to 5 — pushes well past that ceiling within the first dozen or so values, so the running product wraps around modulo 2^32. After enough wrap-arounds, the running total can land exactly on zero (any multiplication where the running value times the next factor produces a multiple of 2^32 will wrap to zero), and once it hits zero everything after stays zero. The same overflow shows up in both Streamer and Cumbersome because both are doing the same multiplication using a 32-bit accumulator — streams don't fix the underlying type problem.

The fix would be to use a `long` (64-bit, ~±9.2 × 10^18, big enough for this dataset) or, for a totally robust solution, a `java.math.BigInteger`. The lab didn't require fixing it, just noticing it.
