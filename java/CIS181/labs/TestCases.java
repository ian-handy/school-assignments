/*
 * Name:
 * Date:
 * Lab 10:
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
	
	
	// Step 6: Take a quick look at the getItemFromArray() method in the Examples class.
	//
	// TODO: Write a test case (following the examples above) called nullPointerTest. This test will determine if the method Examples.getItemFromArray() returns a null value
	// The method assertNull() should help with this. It only takes one argument, the actual value.
	//
	// The test will pass if the actual value is null and will fail otherwise.
	// 
	// Once you have created the test, do the following:
	//	1.) Test Examples.getItemFromArray(0), what do you notice? Do the results match what you expect?
	//	2.) Test Examples.getItemFromArray(1), what do you notice? Do the results match what you expect?
	//	3.) Test Examples.getItemFromArray(2), what do you notice? Do the results match what you expect?
	//	4.) Test Examples.getItemFromArray(3), what do you notice? (Take a look at the Failure Trace)
	
	
	// TODO: Write a test case called arrayIndexOutOfBoundsTest. This test will determine if the method Examples.getItemFromArray() throws an ArrayOutOfBoundsException
	// The method assertThrows should help with this. For an example of how it works, check out the example below:
	//
	//	 @Test
	//	 void numberFormatExceptionTest() {
	//
	//	  Assertions.assertThrows(NumberFormatException.class, () -> {
	//	    Integer.parseInt("One");
	//	  });
	//	 }
	//
	// This test will pass if Integer.parseInt throws a NumberFormatException and will fail otherwise.
	//
	// Your test should pass if Examples.getItemFromArray throws an ArrayIndexOutOfBoundsException and will fail otherwise.
	// 
	// Once you have created the test, do the following:
	//	1.) Test Examples.getItemFromArray(0), what do you notice? Do the results match what you expect?
	//	2.) Test Examples.getItemFromArray(50), what do you notice? Do the results match what you expect?
	
	
	// TODO: Write a test case called TimedTest. This test will determine if the method Examples.factorial executes faster than a specified time
	// The method assertTimeout should help with this. For an example of how it works, check out the example below:
	//
	//		@Test
	//		void time() {
	//			assertTimeout(ofMillis(10), () -> { // What is the max acceptable execution time (in milliseconds)?
	//				Thread.sleep(100);
	//		    });
	//		}
	//
	// This test will pass if Thread.sleep finishes execution in under 1000 milliseconds.
	//
	// Your test should pass if Examples.factorial executes in under 1000 milliseconds
	// 
	// Once you have created the test, do the following:
	//	1.) Test assertTimeout(ofMillis(1000)) and Examples.factorial(7), what do you notice? Do the results match what you expect?
	//	2.) Test assertTimeout(ofMillis(10) and Examples.factorial(4), what do you notice? Do the results match what you expect?
	//	3.) Examples.factorial has a design flaw... We don't want you to fix it, just observe: Test assertTimeout(ofMillis(10) and Examples.factorial(0), what do you notice? Do the results match what you expect?

	
	// TODO: Write a test case called InfiniteLoopTest. This test will decide if the method Examples.factorial executes far longer than it should.
	// The method assertTimeoutPreemptively should help with this. For an example of how it works, check out the example below:
	//
	//		@Test
	//		void time() {
	//			assertTimeoutPreemptively(ofMillis(10), () -> { // What is the max acceptable execution time (in milliseconds)? If it goes beyond that point, it will fail it (infinite loop or not!)
	//				Thread.sleep(1000);
	//		    });
	//		}
	//
	// This test will pass if Thread.sleep finishes execution in under 10 milliseconds.
	//
	// Your test should pass if Examples.factorial executes in under 5000 milliseconds
	// 
	// Once you have created the test, do the following:
	//	1.) Test assertTimeout(ofMillis(10) and Examples.factorial(0), what do you notice? Do the results match what you expect?
	//	2.) Test other combinations of values, note anything interesting you observe.
	//	3.) Now let's be clear here, it is impossible to programmatically test for an infinite loop. So why is this unit test appropriate for this case? Is it always appropriate? Did we just make a huge break through and be nominated for a Turing Award?

	
	// Step 8 TODO: Uncomment this blocks of code and observe their behaviors
	//
	//	
	//	@AfterAll
	//	static void print1() {
	//		// Take a look at the annotation above -> @AfterAll
	//		// This performs after all tests!
	//		System.out.print("an awesome semester! ");
	//	}
	//	
	//	@BeforeAll
	//	static void print2() {
	//		// Take a look at the annotation above -> @BeforeAll
	//		// This performs before all tests!
	//		System.out.print("Thank you all for ");
	//	}
	
	
	// TODO: Add an annotation to each test case, give it a name with: 	@DisplayName("Addition Test")
	//		 You can place it right above the @Test annotation above each method.
	//		 Give a descriptive name to each. Then run your tests an observe the JUnit Runner.
	//		 In the runner you should see the name from the @DisplayName annotation instead of the method names.
	//
	//		 Example:
	//					@DisplayName("Addition Test");
	//					@Test
	//					void test() {
	//					...
	//					}
	//
	//		 That is all for our brief introduction to JUnit.
	//		 For more information on JUnit, please visit: https://junit.org/junit5/docs/current/user-guide/
	//
}
