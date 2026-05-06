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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cumbersome {

	public static void main(String[] args) {
		int list[] = null;

		File f = new File("numbers150.txt");

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


		//Make a new array that contains all numbers to positive numbers, but turn them all positive
		//IntStream streamAbsoluteList = Arrays.stream(list).map(value -> Math.abs(value));
		int[] absoluteList = new int[list.length];
		for (int x = 0; x < list.length; x++) {
			if (list[x] < 0) {
				absoluteList[x] = -list[x];
			} else {
				absoluteList[x] = list[x];
			}
		}


		//Make a new array that only contains the negative numbers from list
		//must be exactly the right size.
		//IntStream streamNegativeList = Arrays.stream(list).filter(i -> i<0);
		int negativeCount = 0;
		for (int x = 0; x < list.length; x++) {
			if (list[x] < 0) {
				negativeCount++;
			}
		}
		int[] negativeList = new int[negativeCount];
		int negIndex = 0;
		for (int x = 0; x < list.length; x++) {
			if (list[x] < 0) {
				negativeList[negIndex] = list[x];
				negIndex++;
			}
		}

		//Print the sum of the original list
		//int sumList = Arrays.stream(list).sum();
		int sumList = 0;
		for (int x = 0; x < list.length; x++) {
			sumList += list[x];
		}
		System.out.println("Original List Sum: " + sumList);

		//Print the sum of the as if all values are positive
		sumList = 0;
		for (int x = 0; x < absoluteList.length; x++) {
			sumList += absoluteList[x];
		}
		System.out.println("Absolute List Sum: " + sumList);

		//Print the sum of just the negative numbers from the  original list
		//sumList = streamNegativeList.sum();
		sumList = 0;
		for (int x = 0; x < negativeList.length; x++) {
			sumList += negativeList[x];
		}
		System.out.println("Sum of just the negative values: " +sumList);

		//Get the sum of numbers not divisible by 4 from list
		//sumList = Arrays.stream(list).filter(value -> (value % 4) !=0) .reduce(0, (runningTotal,nextValue) -> runningTotal + nextValue);
		sumList = 0;
		for (int x = 0; x < list.length; x++) {
			if (list[x] % 4 != 0) {
				sumList += list[x];
			}
		}
		System.out.println("Original List Sum, but only numbers not divisible by 4 using reduce: " + sumList);

		//print out only even numbers from the original list:
		System.out.println("Even numbers from the list:");
		for (int x = 0; x < list.length; x++) {
			if (list[x] % 2 == 0) {
				System.out.print(list[x] + ",");
			}
		}
		System.out.println();

		//get the result of multiplying all non-zero numbers in the list together:
		int product = 1;
		for (int x = 0; x < list.length; x++) {
			if (list[x] != 0) {
				product *= list[x];
			}
		}
		System.out.println("Product: " + product);

	}


}
