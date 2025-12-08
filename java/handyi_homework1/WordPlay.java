import java.util.*;

public class WordPlay {
    public static void main(String[] args) {

        Scanner kbInput = new Scanner(System.in); //New Scanner for keyboard input, now prompt user for information

            System.out.println("Please enter your name:");
            String name = kbInput.nextLine();
            System.out.println("Please enter your age:");
            String age = kbInput.next();
            System.out.println("Please enter your city:");
            String city = kbInput.next();
            System.out.println("Please enter your college:");
            String college = kbInput.next();
            System.out.println("Please enter a profession:");
            String profession = kbInput.next();
            System.out.println("Please enter an animal:");
            String animal = kbInput.next();
            System.out.println("Please enter a pet name:");
            String petName = kbInput.next();
            //Return all user-inputted information with a Mad Libs style story to go along with it.
            System.out.println("There once was a person named " + name + " who lived in "+ city + ".  At the age of " + age + ", " + name + " went to college at " + college + ".  " + name + " graduated and went to work as a "+ profession +".  Then, "+name+" adopted a(n) "+animal+" named "+petName+".  They both lived happily ever after!");

            kbInput.close();
    }
}
