//Ian Handy 10/6/25
import java.io.*;
import java.util.*;



public class PetOrganizer {

	public static void main(String[] args) {
        
        //Check current working directory
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        //Declare Pet Array for 3 pets
        Pet[] petArray = {
            new Pet(),
            new Pet(),
            new Pet()
        };


        //Define scanner
        try {Scanner scanner = new Scanner(new File("./input.txt"));
        //Iterate over the pet array and get required information
        for (int i=0;i<petArray.length;i++) {
            //Set Name
            petArray[i].setPetName(scanner.nextLine());
            //Set Age
            petArray[i].setPetAge(scanner.nextInt());
            //Clear return key
            scanner.nextLine();
            //Set Type
            petArray[i].setPetType(scanner.nextLine());
            //Set Owner
            petArray[i].setPetOwner(scanner.nextLine());
        }
        scanner.close();
        } catch (IOException e) {System.out.println("Error loading file.");}
    
        //Declare printWriter
        try {PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"));
        //Start list
        printWriter.println("\nPatient list:\n");
        //Print out list of all patients by iterating through petArray
        for (int i = 0;i<petArray.length;i++) {
            printWriter.println("\tPet "+(i+1)+":\n");
            printWriter.println("\t\tPet Name: " + petArray[i].getPetName());
            printWriter.println("\t\tPet Age: " + petArray[i].getPetAge());
            printWriter.println("\t\tPet Type: " + petArray[i].getPetType());
            printWriter.println("\t\tPet Owner: " + petArray[i].getPetOwner()+"\n");
        }
        printWriter.close();
	} catch (IOException e) {System.out.println("Error creating file.");}

}


}
