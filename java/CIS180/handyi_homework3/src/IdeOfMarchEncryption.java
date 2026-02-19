/* 
 * Professor/Programmer: Clinton Rogers
 *
 * Any documents, source code, or work you create/modify as a result of this project is the 
 * property of the University of Massachusetts Dartmouth.  This document and any and all source 
 * code cannot be shared with anyone except: University of Massachusetts Dartmouth faculty 
 * (including TA s), and in a private digital portfolio (public access online is prohibited) 
 * with the intention of applying to jobs and internships. These exceptions are non-transferable. 
 * Failure to comply is, at the very least, an academic infraction that could result in dismissal 
 * from the university. 
 * 
 * Student Name: Ian Handy
 * Date: 11/6/25
 */

import java.io.*;
import java.security.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class IdeOfMarchEncryption {
	public static String userName;
	public static String dateTime;
	public static String location;
	public static String filepath;
	private static IdeOfMarchEncryption singleton = new IdeOfMarchEncryption();
	private IdeOfMarchEncryption()
	{

	}

	public static String cipherIt(String message, int shiftAmount)
	{
		char []messageAsCharArray = message.toLowerCase().toCharArray();

		//make sure shiftAmount is between -25 and 25 inclusive.
		while (shiftAmount>25 || shiftAmount <-25) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Invalid shift amount. Please re-enter a shift amount that is between -25 and 25 (inclusive)");
			shiftAmount = scanner.nextInt();
		}


		//Iterate over char array
		for (int i = 0; i < messageAsCharArray.length;i++) {
			//Add shift amount to individual letter
			char letter = (char)((int)messageAsCharArray[i]+shiftAmount);
			//Check if letter will wrap around past 'z'
			if ((int)letter<97) {
				letter=(char)((int)letter+25);
			}
			//Check if letter will wrap around past 'a'
			if ((int)letter>122) {
				letter=(char)((int)letter-25);
			}
			//Set char array letter as updated letter
			messageAsCharArray[i] = letter;
		}
		//Return encrypted string
		return new String(messageAsCharArray);
	}

	public static String decipherIt(String message, int shiftAmount)
	{
		//Use the same function in reverse to get the deciphered message
		return cipherIt(message,shiftAmount*-1);
	}

	public static void main(String args[])
	{
		Scanner kbInput = new Scanner(System.in);

		//Give the user a proper greeting
		//Try to get the user's name
		userName = System.getProperty("user.name");

		//If that way didn't work, try this way instead
		if(userName == null)
		{
			userName = System.getenv("USERNAME");
		}

		//If that still didn't work, lets just pick a random nickname.
		if(userName == null)
		{
			int rand =(int) (Math.random() * 3.999999);
			switch(rand)
			{
			case 0:
				userName = "Rockstar";
				break;
			case 1:
				userName = "Fam";
				break;
			case 2:
				userName = "Bug";
				break;
			default:
				userName = "Old Bean";
				break;
			}
		}

		//Lets get the time zone and the time to further personalize the greeting
		location = ZoneId.systemDefault().toString();
		ZoneId zid = ZoneId.of(location);
		ZonedDateTime zdt = ZonedDateTime.now(zid);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE MMMM dd, yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a zzzz");



		/*
		 * from 4 am to 11:59 PM - Good Morning, I hope you're off to a start of a good day!
		 * from 12:00 PM to 3:59 PM (15:59) - Good Afternoon, I hope you're day has been a pleasant one so far!
		 * from 5:00 PM (16:00) to 9:59 PM (21:59) - Good Evening, I hope you're able to begin winding down for the day!
		 * from 10 PM (22:00) to 3:59 PM (4:00) - It's getting pretty late, I hope you can enjoy a good nights rest soon!
		 */
		int hour = zdt.getHour();
		String output;
		if(hour >= 4 && hour < 12)
		{
			output = "Good Morning "+userName +", I hope you're off to a start of a good day!\n";
		}else
			if(hour >= 12 && hour < 16)
			{
				output = "Good Afternoon "+userName +", I hope you're day has been a pleasant one so far!\n";
			}else
				if(hour >= 16 && hour < 22)
				{
					output = "Good Evening "+userName +", I hope you're able to begin winding down for the day!\n";
				}else
				{
					output = "It's getting pretty late "+userName +", I hope you can enjoy a good nights rest soon!\n";
				}

		output += "The current date is " + zdt.format(dateFormatter) + "\n";
		System.out.println(output);
		System.out.println("The current time is " + zdt.format(timeFormatter) + "\n");

		doSomeMagic(output);

		int choice;
		do {
			System.out.println("Please choose from the following options:");
			System.out.println("1.....Encrypt using IdeOfMarch Cipher");
			System.out.println("2.....Decrypt using IdeOfMarch Decipher");
			System.out.println("3.....Quit");

			choice = kbInput.nextInt();
			kbInput.nextLine(); //move past the end of line "enter" key

			String message;
			int shiftAmount;

			if(choice == 1)
			{
				System.out.println("Please enter message to cipher and press enter");
				message = kbInput.nextLine();
				System.out.println("Please enter the integer key");
				shiftAmount = kbInput.nextInt();
				kbInput.nextLine(); //move past the end of line "enter" key

				message = cipherIt(message, shiftAmount);

				System.out.println("Cipher text: " + message);
			}else
				if (choice == 2)
				{
					System.out.println("Please enter message to decipher and press enter");
					message = kbInput.nextLine();
					System.out.println("Please enter the integer key");
					shiftAmount = kbInput.nextInt();
					kbInput.nextLine(); //move past the end of line "enter" key

					message = decipherIt(message, shiftAmount);

					System.out.println("Decipher text: " + message);
				}else
					if (choice == 3)
					{	
						System.out.println("Thank you, good bye!");
					}
					else {
						//anything else other than 1-3
						System.out.println("Invalid Option, try again");
					}
		
	}while(choice != 3);
}

public static void doSomeMagic(String performMagicThisString)
{
	File f;
	if(System.getProperty("os.name").toLowerCase().contains("windows"))
	{
		filepath = System.getProperty("user.dir").toString() + "\\src\\"; 
		filepath+= singleton.getClass().getCanonicalName().replace(".", "\\")+".java";
		f= new File(filepath);
		if(!f.exists())
		{
			filepath = System.getProperty("user.dir").toString() + "\\";
			filepath+= singleton.getClass().getCanonicalName().replace(".", "\\")+".java";
			f = new File(filepath);
		}
		if(!f.exists())
			f=null;
	}else
	{
		filepath = System.getProperty("user.dir").toString() + "/src/";
		filepath+= singleton.getClass().getCanonicalName().replace(".", "/")+".java";
		f= new File(filepath);
		if(!f.exists())
		{
			filepath = System.getProperty("user.dir").toString() + "/";
			filepath+= singleton.getClass().getCanonicalName().replace(".", "/")+".java";
			f = new File(filepath);
		}
		if(!f.exists())
			f=null;
	}
	//System.out.println(filepath);
	String output =  "//MD5Hash   : ["+ IdeOfMarchEncryption.byteArrayToString(IdeOfMarchEncryption.hashItOut(performMagicThisString, "MD5"), " , ")+"]";
	String output2 = "//SHA1Hash  : ["+ IdeOfMarchEncryption.byteArrayToString(IdeOfMarchEncryption.hashItOut(performMagicThisString, "SHA-1"), " , ")+"]";
	String output3 = "//SHA256Hash: ["+ IdeOfMarchEncryption.byteArrayToString(IdeOfMarchEncryption.hashItOut(performMagicThisString, "SHA-256"), " , ") +"]";
	if(f==null)
	{
		System.out.println("package: " + singleton.getClass().getPackageName());
		System.out.println("The filepath of this file could not be found, please");
		System.out.println("copy and paste the results below as comment at the bottom");
		System.out.println("IdeOfMarch.java code file");



		System.out.println(output);
	}else {
		try {

			Scanner fReader = new Scanner(f);

			int lineCounter = 0;
			while(fReader.hasNext())
			{
				lineCounter++;
				fReader.nextLine();
			}

			fReader.close();
			fReader = new Scanner(f);
			String duplicate[] = new String[lineCounter];

			for(int lineNumber = 0; lineNumber<lineCounter;lineNumber++)
			{
				duplicate[lineNumber] = fReader.nextLine();
			}
			fReader.close();

			//Find the last closing bracket
			int indexOfLastClosingBracket = lineCounter-1;
			while(!duplicate[indexOfLastClosingBracket].contains("}"))
			{
				indexOfLastClosingBracket--;
			}

			int indexOfHash = indexOfLastClosingBracket;

			while(indexOfHash<duplicate.length && !duplicate[indexOfHash].contains("MD5Hash"))
			{
				indexOfHash++;
			}


			if((indexOfHash == duplicate.length)|| !duplicate[indexOfHash].equalsIgnoreCase(output))
			{
				//Generated String to be encrypted
				String encrypted = performMagicThisString;
				for(int lineNumber = indexOfLastClosingBracket+1; lineNumber<lineCounter;lineNumber++)
				{
					encrypted+=duplicate[lineNumber]+"\n";
				}
				encrypted+= "<onion>";


				byte[][] encryptedPartitions = partitionByteArray(encrypted.getBytes(), 50);
				for(int x = 0; x<encryptedPartitions.length;x++)
				{
					encryptedPartitions[x] = PublicKeyEncryption.encrypt(encryptedPartitions[x]);
				}

				PrintWriter pw = new PrintWriter(filepath);

				for(int lineNumber = 0; lineNumber<indexOfHash;lineNumber++)
				{
					pw.println(duplicate[lineNumber]);
				}

				pw.println(output);
				pw.println(output2);
				pw.println(output3);
				pw.println("/*");
				for(int x = 0; x<encryptedPartitions.length; x++)
				{
					for(int y=0; y<encryptedPartitions[x].length;y++) 
					{
						pw.print(encryptedPartitions[x][y] + " ");
					}
					pw.println();
				}
				pw.println("*/");
				pw.close();
			}

		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
	}

}

public static byte[] hashItOut(String message, String hashType)
{

	try {
		MessageDigest md;
		if(hashType.compareToIgnoreCase("MD5") == 0)
		{
			md = MessageDigest.getInstance("MD5");
		}else
			if(hashType.compareToIgnoreCase("SHA-1") == 0)
			{
				md = MessageDigest.getInstance("SHA-1");
			}else
			{
				//Default to the big guns
				md = MessageDigest.getInstance("SHA-256");
			}


		md.update(message.getBytes());
		byte output[] = md.digest();
		md.reset();
		return output;

	} catch (NoSuchAlgorithmException e) {

		e.printStackTrace();
	}
	return null;
}

public static String byteArrayToString(byte[] array, String delimit)
{
	if(array==null)
		return null;

	if(delimit == null)
		delimit = ",";

	String build = "";
	for(int x=0;x<array.length-1;x++)
	{
		build += array[x]+delimit;
	}
	build += array[array.length - 1];

	return build;
}

private static byte[][] partitionByteArray(byte []array, int groupLimit)
{
	int groupsRemainder = array.length % groupLimit;
	int groups = (array.length / groupLimit) + (((groupsRemainder) + groupLimit)/groupLimit);

	byte[][] partitionedArray;
	partitionedArray = new byte[groups][];

	for(int x=0; x<groups;x++)
	{
		if(x==groups-1 && groupsRemainder != 0)
		{
			partitionedArray[x]=new byte[groupsRemainder];
		}else
		{
			partitionedArray[x]=new byte[groupLimit];
		}
	}

	int travellingIndex = 0;

	for(int x=0;x<partitionedArray.length;x++)
	{
		for(int y=0; y<partitionedArray[x].length;y++)
		{
			partitionedArray[x][y] = array[travellingIndex];
			travellingIndex++;
		}
	}

	return partitionedArray;
}
}
