public class MyFirstClassFunctions {

	private static FCFType1 methodAttribute1;

	// Sets the method parameter to the method attribute
	public static void setFCFType1(FCFType1 methodParameter)
	{
		methodAttribute1 = methodParameter;
	}
	
	// Returns the method attribute
	public static FCFType1 getFCFType1()
	{
		return methodAttribute1;
	}
	
	// Returns a lambda expression that multiplies two parameters
	public static FCFType1 getFCFType1Example1()
	{
		return (x, y) -> x * y;
	}
	
	// Returns a lambda expression that prints a string a specified number of times
	public static FCFType2 getFCFType2Example1()
	{
		return (s, y) -> {
			for (int i = 0; i < y; i++) {
				System.out.println(s);
			}
		};
	}
	
	// Returns a reference to the private static method
	public static FCFType2 getFCFType2Example2()
	{
		return MyFirstClassFunctions::thisNameReallyDoesNotMatter;
	}
	
	// Private static method that prints a string and value
	private static void thisNameReallyDoesNotMatter(String str, int value)
	{
		System.out.println("The string is: " + str);
		System.out.println("The value is: " + value);
	}
	
}
