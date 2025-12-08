//Ian Handy 10/15/25
//This program checks the work of Box.java by creating two Boxes and evaluating if they are the same
public class MainClass {

	public static void main(String[] args) {
		//Do not change any code in this class!
		Box b1 = new Box(7,8,9, "Box 1");
		Box b2 = new Box(7,7,7, "Box 2");
		Box b3 = new Box(b1);
		
		System.out.println("Box " + b1.getLabel() + " Stats:");
		System.out.println("Width = " + b1.getWidth());
		System.out.println("Length = " + b1.getLength());
		System.out.println("Height = " + b1.getHeight());
		System.out.println("Volume = " + b1.getVolume());
		
		System.out.println("Box " + b2.getLabel() + " Stats:");
		System.out.println("Width = " + b2.getWidth());
		System.out.println("Length = " + b2.getLength());
		System.out.println("Height = " + b2.getHeight());
		
		//Uncomment this when you complete the method getVolume() in Box.java
		System.out.println("Volume = " + b2.getVolume());
		
		System.out.println("Box " + b3.getLabel() + " Stats:");
		System.out.println("Width = " + b3.getWidth());
		System.out.println("Length = " + b3.getLength());
		System.out.println("Height = " + b3.getHeight());
		
		//TEST CASES, uncomment when you have completed the lab to make sure it works
		if(b1.equals(b3))
		{
			System.out.println("The clone constructor works!");
		}else
		{
			System.out.println("The clone constructor doesn't work!");
		}
		
		//Uncomment all of this when you complete the method compareTo() in Box.java
		System.out.print("Test 1: ");
		if(b1.compareTo(b3)==0)
		{
			System.out.println("Success");
		}else
		{
			System.out.println("Fail");
		}
		
		System.out.print("Test 2: ");
		if(b1.compareTo(b2)>0)
		{
			System.out.println("Success");
		}else
		{
			System.out.println("Fail");
		}
		
		System.out.print("Test 3: ");
		if(b2.compareTo(b1)<0)
		{
			System.out.println("Success");
		}else
		{
			System.out.println("Fail");
		}
	}

}
