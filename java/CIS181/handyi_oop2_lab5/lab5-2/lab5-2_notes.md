# Lab 5 Part 2 — Notes (replaces Lab5-2Analysis.docx)

These are my observations as I worked through Steps 5–13 of Part 2, building up to the final fair-semaphore version of `MyThread`.

## Step 8 — naive `t1.start(); t2.start();` with no yield/sleep/semaphore

Run a few times and the output is almost always one giant block: `hhhhhh...hhhh` (1000 times) followed by `aaaaaa...aaaa` (1000 times). Occasionally I'll see a tiny burst of `a`s break into the middle of the `h`s, but for the most part each thread just runs straight through its loop on whichever core it landed on. The JVM's default thread scheduler hands a thread enough time to finish its tight loop before the OS preempts it, so there's no real interleaving.

## Step 10 — adding `Thread.yield()` after the print

Output looks much more interleaved now — chunks of 5 to 50 of one character before flipping to the other, sometimes single-character switches. `Thread.yield()` is a hint to the scheduler that "I'm willing to give up the CPU"; it does *not* block the thread, it just nudges the scheduler. Whether it actually causes a context switch is up to the OS. So the output is messier and more "interleaved-looking," but still random and not strictly alternating.

## Step 12 — replacing yield with `Thread.sleep(1)`

Output is much more uniformly interleaved — usually `hahaha...` or `ahahah...` for long runs, with occasional double letters where the OS happened to wake one thread right after itself. `Thread.sleep(1)` actually blocks the calling thread for at least 1 millisecond, which is plenty of time for the OS to run the other thread to its next sleep call. So both threads end up effectively taking turns, but it isn't *guaranteed* — the timing is just usually long enough that the other thread gets a chance.

## Step 13 — single static fair `Semaphore(1, true)`

Final code uses one shared `Semaphore(1, true)` declared `static` inside `MyThread`. Each iteration of the run loop does `acquire()` → `print` → `yield`/`sleep(1)` → `release()`. With the fair flag, waiting threads are served in FIFO order, so the moment one thread releases the permit, the *other* thread (which was already waiting) gets it next, even if the releasing thread immediately calls `acquire()` again. That gives strict alternation.

I verified this by piping the program's stdout to a file and checking byte-by-byte: 1000 `h`s, 1000 `a`s, perfectly interleaved as `h, a, h, a, h, a, …`. Every single position 2k is `h` and every position 2k+1 is `a`, all the way through 2000 characters.

**Why one fair semaphore is enough.** The fair queue is what gives us alternation. With an unfair semaphore, a thread could release and immediately re-acquire its own permit before the other thread is scheduled — and you'd be back to the lopsided output from Step 8. The fair flag turns the semaphore from "mutual exclusion" into "mutual exclusion + FIFO ordering," and that ordering is exactly what we need to alternate two threads.

**Caveat.** Strict alternation also depends on *both* threads getting into the wait queue before the first release. If `t1` somehow acquires, prints, and releases all before `t2` even starts its first acquire, we'd see `hh` at the very start of the output. In practice the loop runs long enough (1000 iterations) that this never happens after the first iteration or two — and on my runs the first character is `h` and we then flip cleanly. The yield + sleep(1) inside the critical section help nudge the scheduler so both threads get into steady alternation immediately.
