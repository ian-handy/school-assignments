
public class AgrefilLeldTester {

	public static void main(String[] args) {
		
		int matrixExample1[][] = null;
		
		int matrixExample2[][] = new int[10][];
		
		int matrixExample3[][] = new int[3][];
		matrixExample3[0] = new int[2];
		matrixExample3[1] = new int[5];
		matrixExample3[2] = new int[8];
		
		int matrixExample4[][] = {
				{0,1,2,3,4},
				{4,3,2,1,0},
				{100,-10,12,-100,10},
		};

		int matrixExample5[][] = {
				{0,1,2,3,4},
				{4,3,2,1,0},
				{100,-10,2,-100,10},
		};
		
		int matrixExample6[][] = {
				{0,1,2,3,4},
				{9,8,7,6,5},
				{10,11,12,13,14},
		};
		
		System.out.print("Test 1...");
		if(!AgrefilLeld.compliant(matrixExample1))
			System.out.println("passed!");
		else
			System.out.println("failed!");
		
		System.out.print("Test 2...");
		if(!AgrefilLeld.compliant(matrixExample2))
			System.out.println("passed!");
		else
			System.out.println("failed!");
		
		System.out.print("Test 3...");
		if(!AgrefilLeld.compliant(matrixExample3))
			System.out.println("passed!");
		else
			System.out.println("failed!");
		
		System.out.print("Test 4...");
		if(!AgrefilLeld.compliant(matrixExample4))
			System.out.println("passed!");
		else
			System.out.println("failed!");
		
		System.out.print("Test 5...");
		if(!AgrefilLeld.compliant(matrixExample5))
			System.out.println("passed!");
		else
			System.out.println("failed!");
		
		System.out.print("Test 6...");
		if(AgrefilLeld.compliant(matrixExample6))
			System.out.println("passed!");
		else
			System.out.println("failed!");
	}

}
