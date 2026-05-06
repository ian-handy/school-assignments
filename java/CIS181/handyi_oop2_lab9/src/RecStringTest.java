/*
 * Clinton Rogers
 * Lab9
 */

import java.io.*;
import java.util.*;
import MyADTStack.*;

public class RecStringTest {
	// you need change this value if you need a bigger stack
	public static final int MAX_ITEMS = 10;

	public static void main(String[] args) {
		Scanner kbInput = new Scanner(System.in);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		// test if Stack works
		System.out.println("Testing Stack with array-based implementation");
		if(testStack(true))
			System.out.println("Array based implementation was successful!");
		else
			System.out.println("Array based implementation FAILED!");

		/*System.out.println("\n Continue? (no = 0, yes = any other number)");
		if(kbInput.nextInt() == 0)
		{
			System.out.println("Quitting");
			return;
		}*/
		System.out.println();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		System.out.println("Testing Stack with linked list based implementation");
		if(testStack(false))
			System.out.println("Linked List based implementation was successful!");
		else
			System.out.println("Linked List implementation FAILED!");

		/*System.out.println("\n Continue? (no = 0, yes = any other number)");
		if(kbInput.nextInt() == 0)
		{
			System.out.println("Quitting");
			return;
		}*/

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		String input = getInput();
		StringRecognizer recognizer = new StringRecognizer();

		System.out.println("Array based stack");
		boolean solution1 = recognizer.recognizeString(input,true);
		if (solution1){
			System.out.println(input + " is in language w$w'");
		}else{
			System.out.println(input + " is not in language w$w'");
		}    
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		System.out.println("Linked list based stack");
		boolean solution2 = recognizer.recognizeString(input,false);
		if (solution2){
			System.out.println(input + " is in language w$w'");
		}else{
			System.out.println(input + " is not in language w$w'");
		}
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		if(solution1 == solution2)
		{
			System.out.println("The linked list based and array based implementations concur");
		}else
		{
			System.out.println("The linked list based and array based implementations do not concur, there is a problem.");
		}
	} // end main

	public static String getInput(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String lines = null;
		System.out.print("Please type a string for testing in language w$w':");
		try {
			lines = br.readLine();
		} catch (Exception e) {
			System.out.print("Not a valid input\n");
		}
		System.out.println("input is:"+lines);
		return lines;
	}

	public static boolean testStack(boolean withArray){

		StackInterface<Integer> stack;

		if(withArray)
			stack = new StackArrayBased<Integer>();
		else
			stack = new StackLinkedListBased<Integer>();


		Integer items[] = new Integer[MAX_ITEMS];
		for (int i=0; i<MAX_ITEMS; i++) {
			items[i] = (Integer)i;
			if (!stack.isFull()) {
				stack.push(items[i]);
			}  // end if
		}  // end for

		int count = 9;
		
		boolean success = !stack.isEmpty();
		while (!stack.isEmpty()) {
			// cast result of pop to Integer
			int poppedValue = stack.pop();
			System.out.println(poppedValue);
			success = success&& (poppedValue == count);
			count--;
		}  // end while
		
		//stack is empty, let's pop and see if it throws an exception....
		try {
			stack.pop();
		}catch(StackException e)
		{
			//caught the exception correctly
			System.out.println("Correct Exception Caught:\n\t"+e.getMessage());
		}catch(Exception e)
		{
			//caught the wrong exception 
			System.out.println("Wrong Exception Caught:\n\t"+e.getMessage());
			success = false;
		}

		try {
			stack.peek();
		}catch(StackException e)
		{
			//caught the exception correctly
			System.out.println("Correct Exception Caught:\n\t"+e.getMessage());
		}catch(Exception e)
		{
			//caught the wrong exception 
			System.out.println("Wrong Exception Caught:\n\t"+e.getMessage());
			success = false;
		}
		
		return success;
	}

} // end StackTest