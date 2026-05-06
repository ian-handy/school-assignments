/***********************************************************
 * Name:
 * Date:
 * Description of lab work:
 ***********************************************************/

public class TestCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] s = {2, 5, 11, 19};
		WyvernSphereCollection is = new WyvernSphereCollection(s);
		
		int[] t = {1, 6, 7, 10};
        WyvernSphereCollection is2 = new WyvernSphereCollection(t);

		// Test cases
        
        //Test successfully adding a sphere using addSphere()
		System.out.println("Before insertion: " + is.toString());
		is.addSphere(34);
		System.out.println("After insertion: " + is.toString());

		//Test adding an invalid sphere using addSphere()
		System.out.println("Before insertion: " + is.toString());
		is.addSphere(-88);
		System.out.println("After insertion: " + is.toString());

		//Test all other methods you filled in, both valid and invalid data
		//This includes methods: removeSphere(), union(),intersection(), and complement()
	}

}
