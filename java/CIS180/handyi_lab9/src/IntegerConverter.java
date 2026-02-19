
//Ian Handy 11/10/25
//This program converts a user-provided number into hex, binary, or Roman numerals
import java.util.*;


public class IntegerConverter {
	public static String toHex(int number)
	{
		String total = "";
		
		//If the number is negative, make it positive
		if(number<0)
		{
			number = number*-1;
		}
		
		do{
			int value = number % 16;
			//If the value of 'value' is greater than 9, assign the appropriate letter
			switch(value)
			{
			case 10:
				total+="A";
				break;
			case 11:
				total+="B";
				break;
			case 12:
				total+="C";
				break;
			case 13:
				total+="D";
				break;
			case 14:
				total+="E";
				break;
			case 15:
				total+="F";
				break;
			default:
				total+=value;
					
			}
			
			//divide out 16 and repeat
			number=number/16;
		}
		while(number!=0);
		
		//reverse the string
		total = (new StringBuilder(total)).reverse().toString();
		return total;
	}
	
	public static String toBinary(int number)
	{
		//Same as hex
		String total = "";
		
		if(number<0)
		{
			number = number*-1;
		}
		//Same as hex without case for exceeding values, when dividing by 2 all numbers will be accounted for 
		do{
			int value = number % 2;
			total += value;
			number=number/2;
		}
		while(number!=0);

		//Reverse string and return
		total = (new StringBuilder(total)).reverse().toString();
		return total;
	}
	
	public static String toRomanNumeral(int number)
	{
		//Same as hex
		String total = "";

		//Using absolute value for fun
		number = Math.abs(number);

		//Define list for Roman Numberals and their decimal values
		List<String> roman = new ArrayList<>((Arrays.asList("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I")));
		List<Integer> romanValues = new ArrayList<>((Arrays.asList(1000,900,500,400,100,90,50,40,10,9,5,4,1)));

		//Iterate over number, subtracting the biggest numbers and pushing their Roman Numeral counterparts to the 'total' variable
		for (int i=0;i<roman.size();) {

			int romNum = romanValues.get(i);

			if (number>=romNum) {

				number-=romNum;
				total+=roman.get(i);

			} else {

				i++;

			}
		}

		return total;

	}

}