// No need for your comments here!

public class Examples {
	
	private static String sArray[] = {"Hello", "World!", null};
	
	// Adds two int values together and returns the sum
	public static int add(int one, int two)
	{
		return one + two;
	}
	
	// method that returns an element from sArray at a specified index
	public static String getItemFromArray(int index)
	{
		return sArray[index];
	}
	
	// method that loops the amount of time
	public static long factorial(int value)
	{
		long fac = 1;
		for(int i = 2; i != (value+1); i++)
			fac *= i;
		
		return fac;
	}

}
