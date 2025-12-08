/*Ian Handy 9/15
 * This code declares 3 variables: miles, gallons, and mpg.
 * The code then takes the quotient of the miles and gallons
 * and returns it to the user in a println.
 */

public class MilesPerGallon {
    public static void main(String[] args) {
        int miles = 120;
        double mpg, gallons = 4.0;
        mpg = miles / gallons;
        System.out.println("Your MPG is " + mpg);
    }
}
