/*
 * Name: Ian Handy
 * Date: 2026-04-28
 * Lab 10: JUnit 5 unit tests for Examples.java
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import static java.time.Duration.ofMillis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestCases {

	// Start test //

	// This test uses the add method from the Examples class and determines whether it is running correcty or not.
	@DisplayName("Addition Test")
	@Test
	void test() {
		int sum = Examples.add(3, 5);	// assign 'sum' to the addition of 3 and 5

		// first parameter is the expected value, the second is the actual value.
		assertEquals(8, sum);	// Expected value: 8, Actual value = 8

		/* assertEquals has many variations
		 * For more information see the documentation: https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Assertions.html
		 */
	}
	// End test //


	// Step 5: deliberately failing addition test (4 + 6 != 8) so we can see a red bar in the JUnit runner.
	@DisplayName("Addition Test (failing on purpose)")
	@Test
	void test2() {
		int sum = Examples.add(4, 6);
		assertEquals(8, sum);
	}


	// Step 6: nullPointerTest. sArray = {"Hello", "World!", null}. Index 2 is the only null.
	// Observations from swapping the index:
	//   index 0 -> "Hello"  -> assertNull FAILS (string, not null)
	//   index 1 -> "World!" -> assertNull FAILS (string, not null)
	//   index 2 -> null     -> assertNull PASSES
	//   index 3 -> throws ArrayIndexOutOfBoundsException, the failure trace shows the exception
	// Final committed value uses index 2 so this test passes as part of the suite.
	@DisplayName("Null Pointer Test")
	@Test
	void nullPointerTest() {
		assertNull(Examples.getItemFromArray(2));
	}


	// Step 6 (cont.): arrayIndexOutOfBoundsTest. The lambda must throw ArrayIndexOutOfBoundsException.
	// Observations:
	//   getItemFromArray(0)  -> returns "Hello", no exception, test FAILS
	//   getItemFromArray(50) -> array length is 3, so it throws AIOOBE, test PASSES
	// Final committed value is 50 so this test passes.
	@DisplayName("Array Index Out Of Bounds Test")
	@Test
	void arrayIndexOutOfBoundsTest() {
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Examples.getItemFromArray(50);
		});
	}


	// Step 7: TimedTest using assertTimeout. assertTimeout always lets the lambda finish, then checks
	// elapsed time after the fact.
	// Observations:
	//   assertTimeout(ofMillis(1000), factorial(7)) -> finishes in microseconds, PASSES
	//   assertTimeout(ofMillis(10),   factorial(4)) -> trivially fast, PASSES
	//   assertTimeout(ofMillis(10),   factorial(0)) -> factorial(0) is an infinite loop
	//                                                  (the for-loop condition i != value+1 starts at 2
	//                                                  and can never equal 1), so assertTimeout never
	//                                                  returns. The test hangs rather than failing,
	//                                                  which is the design flaw of assertTimeout.
	// Final committed value passes: factorial(7) under 1000ms.
	@DisplayName("Timed Test (factorial under 1000ms)")
	@Test
	void TimedTest() {
		assertTimeout(ofMillis(1000), () -> {
			Examples.factorial(7);
		});
	}


	// Step 7 (cont.): InfiniteLoopTest using assertTimeoutPreemptively. This variant runs the lambda
	// on a separate thread and aborts it if it takes too long, so it actually catches infinite loops.
	// Observations:
	//   assertTimeoutPreemptively(ofMillis(10), factorial(0)) -> factorial(0) loops forever, but the
	//                                                            preemptive timer kills the thread at
	//                                                            10ms and the test FAILS (correctly).
	// Why this is appropriate: it gives us an upper bound on how long a method should take. If the
	// method blows past that bound, something is wrong (infinite loop, accidental quadratic blowup,
	// blocked I/O, etc.). It does NOT prove the absence of an infinite loop in general — only that
	// THIS particular execution finished in time. So no, no Turing Award; we're just bounding the
	// runtime, not solving the halting problem. It is appropriate when there's a known performance
	// budget for the method, and inappropriate when the method's runtime depends heavily on input.
	// Final committed value passes: factorial(7) under 5000ms preemptively.
	@DisplayName("Infinite Loop Test (preemptive 5s timeout)")
	@Test
	void InfiniteLoopTest() {
		assertTimeoutPreemptively(ofMillis(5000), () -> {
			Examples.factorial(7);
		});
	}


	// Step 8: @AfterAll and @BeforeAll fire once around the whole class.
	// Observation: console prints "Thank you all for an awesome semester! " — @BeforeAll runs first
	// even though it's declared second.

	@AfterAll
	static void print1() {
		// Take a look at the annotation above -> @AfterAll
		// This performs after all tests!
		System.out.print("an awesome semester! ");
	}

	@BeforeAll
	static void print2() {
		// Take a look at the annotation above -> @BeforeAll
		// This performs before all tests!
		System.out.print("Thank you all for ");
	}

}
