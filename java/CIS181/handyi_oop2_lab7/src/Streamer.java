/*
 * Student Name: Ian Handy
 * Date: 2026-04-28
 *
 * Lab 7 Step 8 observation:
 * When the program is run against numbers150.txt instead of numbers15.txt,
 * the "Product" line is glaringly wrong — it comes out as a negative
 * number (or sometimes zero) even though every input number is non-zero.
 * The reason is integer overflow. An int in Java is a 32-bit signed value
 * with a max of ~2.1 billion. Multiplying ~150 non-zero numbers together
 * blows past that ceiling almost immediately, so the running product wraps
 * around the int range and the final result is meaningless. The fix would
 * be to use a long (or better, a BigInteger), but the lab does not require
 * it — we just had to observe the issue.
 */

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Streamer {

	public static void main(String[] args) {

		int list[] = null;

		File f = new File("numbers15.txt");

		Scanner fileInput;
		try {
			fileInput = new Scanner(f);


			int size = fileInput.nextInt();

			list = new int[size];

			//Generate 200 random numbers and add them to list.
			for(int x = 0; x<list.length;x++)
			{
				list[x]=fileInput.nextInt();
			}
			fileInput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(list == null)
		{
			System.out.println("Yo, you did not import the numbers file correctly.");
			System.out.println("Is it in the src folder by accident and not the ");
			System.out.println("project folder? Maybe you spelled it wrong in the code?");

			return;
		}

		//This code converts the array "list" to a stream: Arrays.stream(list)

		/*                                 Map
		 * Map allows for a collection of data to run through a method/lambda
		 * one by one to produce a new collection, or stream, of that data
		 */

		//Make a new stream that converts all numbers to positive numbers
		IntStream streamAbsoluteList = Arrays.stream(list).map(value -> Math.abs(value));

		/*                                 Filter
		 * Filter allows for the creation of a new stream, but the data in the
		 * new stream but fit some boolean condition.  In essence it filters
		 * out data that doesn't fit within the boolean condition.
		 */
		//Make a new stream that only keeps the negative numbers
		IntStream streamNegativeList = Arrays.stream(list).filter(i -> i<0);



		/*                                 Reduce/fold
		 * Reduce/folding allows for a collection of data to run through a method/lambda
		 * one by one to produce a desired single result
		 */

		/*
		 * If we want the sum of all the data of a collection, we already have the sum
		 * method built in to Streams:
		 */

		//Print the sum of the original list
		int sumList = Arrays.stream(list).sum();
		System.out.println("Original List Sum: " + sumList);

		//Print the sum of the as if all values are positive
		sumList = streamAbsoluteList.sum();
		System.out.println("Absolute List Sum: " + sumList);

		//Print the sum of just the negative numbers from the  original list
		sumList = streamNegativeList.sum();
		System.out.println("Sum of just the negative values: " +sumList);

		/*
		 * Other built in methods include count() and average().
		 * There will be other methods that we want to apply to our collection of data
		 * beyond sum(), count(), and average().
		 *
		 * In these case we can use the method reduce(). This method takes two parameters,
		 * an initial value, and a lambda expression or method that is to be applied to the
		 * entire list.  The initial value represents an accumulator variable.
		 * method built in to Streams:
		 */

		//As an example, get the sum using reduce
		sumList = Arrays.stream(list).reduce(0, (runningTotal,nextValue) -> runningTotal + nextValue);
		System.out.println("Original List Sum, but using reduce: " + sumList);

		//If I'm clever about it, I can also use map to print out the array using a two statement lambda...
		System.out.println("Array contents:");
		Arrays.stream(list).reduce(0, (a,b) -> {System.out.print(b + ","); return 0;});
		System.out.println();

		//We can combine filter with either map or reduce to comb out values as well
		//below, we filter out numbers that are evenly divisible by 4, and get the sum.
		sumList = Arrays.stream(list).filter(value -> (value % 4) !=0) .reduce(0, (runningTotal,nextValue) -> runningTotal + nextValue);
		System.out.println("Original List Sum, but only numbers not divisible by 4 using reduce: " + sumList);

		//Your turn..........................

		//Use filter() and reduce() to print out only even numbers from the original list:
		System.out.println("Even numbers from the list:");

		Arrays.stream(list).filter(value -> value % 2 == 0).reduce(0, (a, b) -> {System.out.print(b + ","); return 0;});

		System.out.println();

		//Use filter() and reduce to get the result of multiplying all non-zero numbers in the list together:
		int product = 0;

		product = Arrays.stream(list).filter(value -> value != 0).reduce(1, (runningProduct, nextValue) -> runningProduct * nextValue);

		System.out.println("Product: " + product);


	}

}
