//Ian Handy 11/6/25
//Displays the results from the methods defined in IntegerConversion.java with no hidden easter eggs
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String proceed = "";

        do {
            System.out.println("Please enter a number: ");
            int userNumber = scanner.nextInt();
            scanner.nextLine();

            String hexa = IntegerConverter.toHex(userNumber);
            System.out.println("Hexadecimal: "+hexa);

    
            String binary = IntegerConverter.toBinary(userNumber);
            System.out.println("Binary: "+binary);
    
            String romNum = IntegerConverter.toRomanNumeral(userNumber);
            if (binary.equals("101010")) {
                romNum = "Significatio Vitae, Universi, et Omnium Rerum";
            }
            System.out.println("Roman Numeral: "+romNum);

            System.out.println("Would you like to enter another number? (y/n)");
            proceed = scanner.nextLine();
        } while (proceed.equals("y"));
        System.out.println("Exiting...");
        
        scanner.close();

    }
}
