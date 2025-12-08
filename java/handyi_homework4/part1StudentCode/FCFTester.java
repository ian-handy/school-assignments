import java.util.*;

public class FCFTester {

	public static void main(String[] args) {

		FCFType1 functionCodeVariable1;

		FCFType2 functionCodeVariable2;

		//Set a simple lambda expression
		MyFirstClassFunctions.setFCFType1((one,two) -> one + two);

		//Now lets get it back and make sure it works
		functionCodeVariable1 = MyFirstClassFunctions.getFCFType1();

		//Lets run it through a bunch of time with random numbers and see if it works
		int value1, value2, returnValue;
		Random rand = new Random();

		System.out.println("Test 1");
		
		boolean passed = true;
		for(int loop=0;loop<100;loop++)
		{
			//Random number 1
			value1 = rand.nextInt();

			//Random number 2
			value2 = rand.nextInt();

			//Feed it into the variable and get what it spits out
			returnValue = functionCodeVariable1.execute(value1, value2);

			if(returnValue != (value1 + value2))
			{
				passed = false;
				System.out.println(value1 + " + " + value2 + " does not equal " + returnValue);
			}

		}
		if(passed)
		{
			System.out.println("It appears you implemented the methods setFCFType1() and getFCFType1() correctly");
		}else
		{
			System.out.println("Either or Both methods setFCFType1() and getFCFType1() are not working incorrectly");
			System.out.println("See examples above for the cases were it did not work correctly");
		}

		//Lets get FCFType1Example1
		functionCodeVariable1 = MyFirstClassFunctions.getFCFType1Example1();

		//Lets run it through a bunch of time with random numbers and see if it works
		System.out.println("\nTest 2");
		
		passed = true;
		for(int loop=0;loop<100;loop++)
		{
			//Random numbers
			value1 = rand.nextInt();
			value2 = rand.nextInt();

			//Feed it into the variable and get what it spits out
			returnValue = functionCodeVariable1.execute(value1, value2);

			//Make sure it did the math correctly
			if(returnValue != (value1 * value2))
			{
				//Nopers, you failed
				passed = false;
				System.out.println(value1 + " * " + value2 + " does not equal " + returnValue);
			}

		}
		if(passed)
		{
			System.out.println("It appears you implemented the methods getFCFType1Example1() correctly");
		}else
		{
			System.out.println("It appears you implemented the methods getFCFType1Example1() incorrectly");
			System.out.println("See examples above for the cases were it did not work correctly");
		}

		System.out.println("\nTesting FCFType2Example1");
		//Lets get FCFType2Example1
		functionCodeVariable2 = MyFirstClassFunctions.getFCFType2Example1();

		//run it
		functionCodeVariable2.execute("*", 5);

		System.out.println("\nTesting FCFType2Example2");
		//Lets get FCFType2Example2
		functionCodeVariable2 = MyFirstClassFunctions.getFCFType2Example2();

		//run it
		functionCodeVariable2.execute("*", 5);
	}

}
