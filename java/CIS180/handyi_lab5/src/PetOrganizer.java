//Ian Handy 10/8/25
import java.util.*;

public class PetOrganizer {

	public static void main(String[] args) {
        //Define scanner
        Scanner scanner = new Scanner(System.in);

        //Declare Pet Array for 3 pets
        Pet[] petArray = {
            new Pet(),
            new Pet(),
            new Pet()
        };
        
        //Iterate over the pet array and get required information
        for (int i=0;i<petArray.length;i++) {
            //Set Name
            System.out.println("\nWhat is the name of pet "+(i+1)+"?");
            petArray[i].setPetName(scanner.nextLine());
            //Set Age
            System.out.println("What is the age of "+petArray[i].getPetName()+"?");
            petArray[i].setPetAge(scanner.nextInt());
            //Clear return key
            scanner.nextLine();
            //Set Type
            System.out.println("What type of animal is "+petArray[i].getPetName()+"?");
            petArray[i].setPetType(scanner.nextLine());
            //Set Owner
            System.out.println("Who is "+petArray[i].getPetName()+"'s owner?");
            petArray[i].setPetOwner(scanner.nextLine());
        }
        scanner.close();
        
        //Start list
        System.out.println("\nPatient list:\n");
        //Print out list of all patients by iterating through petArray
        for (int i = 0;i<petArray.length;i++) {
            System.out.println("\tPet "+(i+1)+":\n");
            System.out.println("\t\tPet Name: " + petArray[i].getPetName());
            System.out.println("\t\tPet Age: " + petArray[i].getPetAge());
            System.out.println("\t\tPet Type: " + petArray[i].getPetType());
            System.out.println("\t\tPet Owner: " + petArray[i].getPetOwner()+"\n");
        }
	}

}
