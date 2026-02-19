/*Ian Handy 9/15
 * This code declares 3 variables: hours, grossPay, and payRate.
 * The code then takes the product of the hours and payRate and 
 * returns it to the user in a println.
 */

public class Payroll {
    public static void main(String[] args) {
        int hours = 40;
        double grossPay, payRate = 25.0;
        grossPay = hours * payRate;
        System.out.println("Your gross pay is $" + grossPay);
    }
}
