# Lab 10 — Observations

These are the running observations from Steps 5–9. The same notes are captured inline in `TestCases.java` next to the relevant test methods.

## Step 5 — break the addition test on purpose (`test2`)

`Examples.add(4, 6)` returns 10, but the assertion still expects 8, so the test fails. The JUnit failure trace reports `expected: <8> but was: <10>` and the status bar turns red. This is the whole point of the step — it shows what a failing test looks like.

## Step 6 — `nullPointerTest`

`sArray = {"Hello", "World!", null}`. Sweeping the index value:

| Index | Result of `getItemFromArray(i)` | `assertNull` outcome | Notes |
|---|---|---|---|
| 0 | `"Hello"` | FAIL | string is not null |
| 1 | `"World!"` | FAIL | string is not null |
| 2 | `null` | PASS | the only null entry |
| 3 | throws `ArrayIndexOutOfBoundsException` | FAIL | failure trace shows the exception, not a normal assertion mismatch |

The committed test uses index 2 so it passes inside the suite.

## Step 6 — `arrayIndexOutOfBoundsTest`

We use `assertThrows(ArrayIndexOutOfBoundsException.class, ...)`. Sweeping the index:

| Index | Behavior | Test outcome |
|---|---|---|
| 0 | returns `"Hello"`, no exception | FAIL — `assertThrows` requires the throw |
| 50 | array length is 3, AIOOBE | PASS |

The committed test uses index 50 so it passes.

## Step 7 — `TimedTest` (using `assertTimeout`)

`assertTimeout` runs the lambda to completion and only checks the elapsed time afterward — it does not interrupt long-running code.

| Setup | Result |
|---|---|
| `assertTimeout(ofMillis(1000))` + `factorial(7)` | PASS — finishes in microseconds |
| `assertTimeout(ofMillis(10))` + `factorial(4)` | PASS — still trivially fast |
| `assertTimeout(ofMillis(10))` + `factorial(0)` | HANGS — never returns |

The factorial design flaw: the loop is `for (int i = 2; i != value+1; i++)`. With `value == 0`, we start at `i = 2` and check `i != 1`, which is always true, so the loop runs forever. `assertTimeout` doesn't preempt the lambda, so the JUnit run never completes — that's the limitation of `assertTimeout`. The committed test uses `factorial(7)` under a generous 1000ms budget so it passes.

## Step 7 — `InfiniteLoopTest` (using `assertTimeoutPreemptively`)

`assertTimeoutPreemptively` runs the lambda on a separate thread and aborts it when the deadline expires, so it actually catches infinite loops.

| Setup | Result |
|---|---|
| `assertTimeoutPreemptively(ofMillis(10))` + `factorial(0)` | FAIL after ~10ms — test correctly reports the timeout instead of hanging the suite |
| `assertTimeoutPreemptively(ofMillis(5000))` + `factorial(7)` | PASS |

**"Why is this unit test appropriate for this case? Is it always appropriate? Did we just make a huge breakthrough and earn a Turing Award?"**

It is appropriate when there's a known runtime budget for a method — a hard upper bound that, if exceeded, almost certainly indicates something has gone wrong (infinite loop, accidental quadratic blowup, blocked I/O, deadlock, etc.). It catches the most common pathological cases without us having to formally reason about termination.

It is not always appropriate. If a method's runtime depends heavily on the input size, or if the test runs on a machine with variable performance (a busy CI box, a laptop on battery saver, etc.), the timeout will fire flakily and you'll get false failures. It also doesn't actually prove the absence of an infinite loop — it only proves that this one execution finished in time. So no Turing Award; we have not solved the halting problem, we've just put a clock on a single run.

## Step 8 — `@BeforeAll` and `@AfterAll`

After uncommenting the two static methods, JUnit prints `Thank you all for an awesome semester! ` around the test run — `@BeforeAll` fires once before any `@Test` and `@AfterAll` fires once after them, regardless of declaration order. (When run from the JUnit console launcher the prints land in the launcher's stdout, not in Eclipse's JUnit tab, but the lifecycle behavior is the same.)

## Step 9 — `@DisplayName`

Each test method got a `@DisplayName` annotation. In the Eclipse JUnit runner (and the console runner), the human-readable display name shows in the tree instead of the method name, e.g. "Addition Test" instead of `test`, "Infinite Loop Test (preemptive 5s timeout)" instead of `InfiniteLoopTest`, etc.
