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
 * Date: 2/3/26
 */

import java.io.*;
import java.security.*;
import java.util.*;

public class SimpleAsymKeyEncryptApp {

	public static void main(String[] args) {

		//Used to get the users choice from the 
		int choice;

		//Other implementations other than RSA do not work without messing with Eclipse's settings
		PublicKeyEncryption pke1 = new PublicKeyEncryption(PublicKeyEncryption.AlgorithmTypes.RSA);

		//Keyboard input.
		Scanner kbInput = new Scanner(System.in);


		String bufferData;
		byte encryptedData[], decryptedData[];
		PublicKey publicK;
		PrivateKey privateK;

		System.out.println("\n\n=======================================================");
		System.out.println("Welcome to the Simple Asymmetric Key Encryption Program");
		System.out.println("=======================================================");

		do {

			System.out.println("\nPlease choose from the following options:");
			System.out.println("1. Save my public key to a binary file.");
			System.out.println("2. Save my private key to a binary file.");
			System.out.println("3. Generate a new set of my keys.");
			System.out.println("4. Encrypt using my key");
			System.out.println("5. Decrypt using my key");
			System.out.println("6. Encrypt using a key from a file");
			System.out.println("7. Decrypt using a key from a file");
			System.out.println("8. Quit the program\n");

			//get the users choice
			choice = kbInput.nextInt();
			kbInput.nextLine();//buffer out the end of line character.
			System.out.println("\n");

			
			switch(choice) {

			case 1://Save my public key to a binary file.
				{
					saveByteArrayToFile(pke1.getPublicKeyAsByteArray(), "MyPublicKey.key");
					System.out.println("Public Key Created");
					break;
				}
			case 2://Save my private key to a binary file.
				{
					saveByteArrayToFile(pke1.getPrivateKeyAsByteArray(), "MyPrivateKey.key");
					System.out.println("Private Key Created");
					break;
				}
			case 3://Generate a new set of my keys.
				{
					pke1.generateNewPair();
					System.out.println("Public Key Created");
					System.out.println("Private Key Created");
					break;
				}
			case 4://Encrypt using my key
				{
					String bufferName = setFileName("File to be encrypted");
					String encryptedName = setFileName("Output file");

					bufferData = getTextFileAsString(bufferName);
					encryptedData = pke1.encrypt(bufferData.getBytes());
					saveByteArrayToFile(encryptedData, encryptedName);

					System.out.println("Text from"+ bufferName +" has been encrypted using your public key");
					System.out.println("and saved to " + encryptedName);
					break;
				}
			case 5://Decrypt using my key
				{
					String encryptedName = setFileName("Currently encrypted file");
					encryptedData = loadByteArrayFromFile(encryptedName);
					decryptedData = pke1.decrypt(encryptedData);

					System.out.println("Decrypted Text:");
					System.out.println(new String(decryptedData));
					break;
				}
			case 6://Encrypt using a key from a file
				{
					String bufferName = setFileName("File to be encrypted");
					String keyName = setFileName("Public Key File");
					String encryptedName = setFileName("Encrypted File");
					bufferData = getTextFileAsString(bufferName);
					publicK = pke1.convertBytesToPublicKey(loadByteArrayFromFile(keyName));
					encryptedData = pke1.encrypt(bufferData.getBytes(), publicK);
					saveByteArrayToFile(encryptedData, encryptedName);

					System.out.println("Text from" + bufferName + " has been encrypted using your public key");
					System.out.println("and saved to " + encryptedName);
					break;
				}
			case 7://Decrypt using a key from a file
				{
					String keyName = setFileName("Private Key File");
					String encryptedName = setFileName("Currently Encrypted File");
					String outputName = setFileName("Output File");

					try {
					PrintWriter pw = new PrintWriter(outputName);

					encryptedData = loadByteArrayFromFile(encryptedName);				
					privateK = pke1.convertBytesToPrivateKey(loadByteArrayFromFile(keyName));

					decryptedData = pke1.decrypt(encryptedData,privateK);

					pw.write(new String(decryptedData));
					pw.close();
					System.out.println("Decryption saved as \""+ outputName +"\"");

						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					break;
				}
			case 8:
				{
					System.out.println("Thank you for using this program, good bye!");
					break;
				}
			default://invalid choice
				{
					System.out.println("Invalid Choice, press enter to continue.");
					kbInput.nextLine();
					break;
				}

			}
		} while (choice != 8);
	}

	private static void saveByteArrayToFile(byte arrayData[], String fileName)
	{
		//Just dump the whole thing to a binary file.
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			fos.write(arrayData);
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static byte[] loadByteArrayFromFile(String fileName)
	{
		//Just dump the whole thing to a binary file.
		try {
			FileInputStream fis = new FileInputStream(fileName);
			byte buffer[] = fis.readAllBytes();
			fis.close();

			return buffer;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String getTextFileAsString(String filename)
	{
		File f = new File(filename);

		String bufferString = "";

		Scanner fileInput;
		try {
			fileInput = new Scanner(f);

			while(fileInput.hasNext())
			{
				bufferString+=fileInput.nextLine() + "\n";
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return bufferString;
	}

	private static String setFileName(String type)
	{
		Scanner kbInput = new Scanner(System.in);
		System.out.print("Need file name for (" + type + ")\n");
		System.out.print("Enter the filename (with extension): ");
		String filename = kbInput.nextLine();
		return filename;
	}

}
