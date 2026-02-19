import java.util.*;
public class PartyTable {
    //Function to format prices
    public static String formatPrice(Double price) {
        return String.format("$%.2f", price);
    }
    public static void main(String[] args) {

        //Declare scanner
        Scanner scanner = new Scanner(System.in);

        //Get head count
        System.out.println("Please enter how many people will be in attendance:");
        double headCount = scanner.nextDouble();
        scanner.close();

        //Calculate tables and seats required
        double perTable = 11.0;
        int tablesUsed = (((int)headCount+10) / (int)perTable);

        double seatGroup = 5.0;
        int seatGroupsUsed = ((int)(headCount+4.0) / (int)seatGroup);

        System.out.println("For "+(int)headCount+" people, you will need "+tablesUsed+" tables and "+seatGroupsUsed+" seat groups.");

        int totalSeats = (int)seatGroup * (int)seatGroupsUsed;
        int unusedSeats = totalSeats  - (int)headCount;
        System.out.println("There will be a total of " + totalSeats + " seats, " + unusedSeats + " of which will remain vacant.");

        int seatsAvailable = (int)(seatGroupsUsed*seatGroup - perTable*tablesUsed);
        System.out.println(seatsAvailable + " seats will not be able to fit at the tables.");

        //Calculate subtotal
        double tableCost = 24.99 * tablesUsed;
        double seatGroupCost = 22.49 * seatGroupsUsed;
        System.out.println("Cost of tables: " + formatPrice(tableCost) + "\nCost of seats: " + formatPrice(seatGroupCost));
        double subtotal = tableCost + seatGroupCost;
        double costPerPerson = subtotal / headCount;
        System.out.println("The subtotal comes out to "+formatPrice(subtotal)+".\nThe cost per attendee is "+formatPrice(costPerPerson)+".");

        //Calculate the final total with tax (and also the tax alone)
        double finalTotal = 1.0625 * subtotal;
        System.out.println("Tax on your order comes out to "+formatPrice(finalTotal-subtotal)+".\nThe final total comes out to "+formatPrice(finalTotal));
    }
}

// Party Table Calculator (60 points total)
// You know what’s fun?  Throwing a party!  You know what’s not fun (besides having to clean up afterward that is), doing math to determine how many tables and seats you need at the venue. So, to that end, you’re going to write a program that when given the number of guests will tell you how many seats to rents, and how many tables to rent.

// The company Hamstring Shelf will provide the rentals for the seats.  Known for their superb comfort, their pricing structure leaves something to be desired.  You are only allowed to rent seats in groups of 5.  For example, if you have 14 people coming, you’ll need to rent 3 groups of seats, for a total of 15 seats (3 groups * 5 seats per group) with 1 seat that just won’t be used. Each group of seats costs $22.49 for the day.

// The company Arthurs Round Tables (a subsidiary of the same parent company) will provide the rentals for the tables.  Known for their regal roundness fit for a group of knights, each table can fit 11 people each.  For example, if you have 14 people coming, you’ll need to rent 2 tables, which can accommodate 22 people (2 tables * 11 people per table), with 8 places being empty.  Each table costs $24.99 for the day.

// The program should ask the user for how many that will be in attendance (a head count) (3 points). 

// Based on the information from the user your program should calculate and display with the restriction that you CANNOT use if structures, if/else structures, switch, loops, conditional ternary operators, Math class functions/methods or alike, etc., you must calculate all of this using pure mathematical operations (+, -, *, /, and %) only for full credit. If you decide something other than pure mathematical operations, you will receive a 10 point deduction.

// The minimum number seat group rentals that will be required. (10 points)
// The total number of seats. (3 points)
// The number of seats that will not be used. (3 points)
// The minimum number tables that will be required. (10 points)
// The total number of places at the tables available. (3 points)
// The number of places that will be left unoccupied. (3 points)
// The total cost of the seat rentals. (3 points)
// The total cost of the table rentals. (3 points)
// The subtotal (total cost of seats + total cost of tables). (3 points)
// The tax (6.25% on the subtotal). (3 points)
// The total cost (subtotal + tax). (3 points)
// Note: you may use the double data type (variable) to calculate the costs.  Also, this may be worth looking at: https://java2blog.com/format-double-to-2-decimal-places-java/Links to an external site.

// ***

// Additional points:

// Comments: 10 points