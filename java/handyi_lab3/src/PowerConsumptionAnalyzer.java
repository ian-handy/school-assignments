//Ian Handy
//9/22/25
//Calculate the cost of keeping a device on for a given duration of time.

import java.util.*;

public class PowerConsumptionAnalyzer {

    //Step 1. Create function to format doubles into currency.
    public static String formatPrice(Double price) {
        return String.format("$%.2f", price);
    }

    public static void main(String[] args) {

        //Step 2. Declare Scanner
        Scanner scanner = new Scanner(System.in);

        //Step 3. Get input for voltage
        System.out.println("Enter the voltage coming from the outlet: ");
        double voltage = scanner.nextDouble();

        //Step 4. Get input for amps
        System.out.println("Enter the amps that the device uses: ");
        double amps = scanner.nextDouble();

        //Step 5. Get input for kwh charge
        System.out.println("Enter the cost per kw/h: ");
        double charge = scanner.nextDouble();
        
        //Step 6. Get input for no. minutes device is on
        System.out.println("Enter the number of minutes the deivce will be on per day: ");
        double minutesOn = scanner.nextDouble();

        //Step 7. Get input for no. days device is on
        System.out.println("Enter the number of days you would like the project the cost for: ");
        int daysOn = scanner.nextInt();

        //Step 8. Calculate/print Watts (amperage * voltage)
        double watts = amps * voltage;
        System.out.println("Watts: " + watts);

        //Step 9. Calculate/print Kilowatts (Watts/1000)
        double kilowatts = watts/1000.00;
        System.out.println("Kilowatts: " + kilowatts);
        //Step 10. Calculate/print kw/day (kw * (minutes on/60))
        double kwDay = minutesOn/60*kilowatts;
        System.out.println("Kilowatts/Day: " + kwDay);

        //Step 11. Calculate/print cost per day (kw/day * kwh charge)
        double costDay = kwDay * charge;
        System.out.println("Cost per day: " + formatPrice(costDay));
        
        //Step 12. Calculate/print projected total cost (cost per day * days on)
        double costProject = costDay * daysOn;
        System.out.println("Cost for " + (int)daysOn + " days: " + formatPrice(costProject));

        scanner.close();

    }
}

