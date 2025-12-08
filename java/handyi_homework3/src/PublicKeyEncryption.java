/* 
 * Professor/Programmer: Clinton Rogers
 *
 * Any documents, source code, or work you create/modify as a result of this project is the 
 * property of the University of Massachusetts Dartmouth.  This document and any and all source 
 * code cannot be shared with anyone except: University of Massachusetts Dartmouth faculty 
 * (including TA�s), and in a private digital portfolio (public access online is prohibited) 
 * with the intention of applying to jobs and internships. These exceptions are non-transferable. 
 * Failure to comply is, at the very least, an academic infraction that could result in dismissal 
 * from the university. 
 * 
 * Student Name: Ian Handy
 * Date:11/6/25
 */


import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class PublicKeyEncryption {


	private static String algorithmName = "RSA";

	private final static byte publicKey[] = {48, 
			-127, -97, 48, 13, 6, 9, 42, -122, 72, -122, 
			-9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 
			0, 48, -127, -119, 2, -127, -127, 0, -100, -43, 
			-49, 72, 84, -78, -73, 72, -76, -35, 73, -35, 
			30, 7, 104, -50, 77, 56, 101, 121, 13, 98, 
			81, 113, -84, -19, -48, -121, 68, 112, 123, -54, 
			51, -127, -95, -33, -106, -78, 4, 4, -91, -2, 
			-23, 26, -21, 2, 13, -84, 28, 92, 38, -124, 
			-105, 121, -39, 110, 33, -27, -37, -103, -22, -14, 
			-49, -125, -59, -97, 22, 42, 79, 111, 76, 4, 
			-85, 83, 34, -46, -127, -65, 89, -38, -120, -38, 
			80, -119, 100, -82, -124, 118, 6, 67, 98, 19, 
			50, 33, 42, 78, -13, -3, -122, -16, 91, 35, 
			-92, 19, 74, -126, -41, 49, 67, -17, -87, -51, 
			-127, 29, 47, 45, -92, 75, 105, -100, 53, -39, 
			-114, -11, 62, 104, -3, 65, 2, 3, 1, 0, 
			1};	

	public static byte[] encrypt(byte[] dataToBeEncrypted)
	{
		PublicKey key = convertBytesToPublicKey(publicKey);
		if(key==null)
		{
			System.out.println("Invalid public key, program quitting");
			System.exit(-1);
		}

		byte[][] arrayOfArrays = new byte[dataToBeEncrypted.length/100 + 1][100];
		int messages = 0;
		int currentIndex = 0;
		for(int x=0;x<dataToBeEncrypted.length;x++)
		{
			arrayOfArrays[messages][currentIndex] = dataToBeEncrypted[x];
			currentIndex++;
			if(currentIndex == 100)
			{
				currentIndex = 0;
				messages++;
			}
		}
		Cipher cipher;
		try {
			
			cipher = Cipher.getInstance(algorithmName);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return cipher.doFinal(dataToBeEncrypted);

		}
		catch (NoSuchPaddingException e) {
			e.printStackTrace();
			System.out.println("No Such Padding issue! Program Exiting!");
			System.out.flush();
			System.exit(-1);
		}
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
			System.out.println("No Such Padding issue! Program Exiting!");
			System.out.flush();
			System.exit(-1);
		}
		catch (IllegalBlockSizeException e)
		{
			e.printStackTrace();
			System.out.println("Illegal Block Size Issue! Program Exiting!");
			System.out.flush();
			System.exit(-1);
		}
		catch (BadPaddingException e)
		{
			e.printStackTrace();
			System.out.println("Bad Padding issue! Program Exiting!");
			System.out.flush();
			System.exit(-1);
		}
		catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
			System.out.println(algorithmName + " algorithm type not supported! Program Exiting!");
			System.out.flush();
			System.exit(-2);
		}

		//Should be unreachable code.  Either it returns the encrypted data, or it exits the program.
		return null;
	}



	private static PublicKey convertBytesToPublicKey(byte[] keyAsBytes)
	{
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyAsBytes);
		KeyFactory kf;
		try {
			kf = KeyFactory.getInstance(algorithmName);
			PublicKey pk = kf.generatePublic(spec);
			return pk;

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}



