//Ian Handy 10/27/25
import java.util.*;
public class RunningTotal {

    ArrayList<Double> numbers = new ArrayList<>();

    public void getNumbersFromUser() {

        Scanner scanner = new Scanner(System.in);

        //Create number to write to
        double currentNumber = 0.0;

        //Get numbers from user
        while (currentNumber>=0) {
            System.out.println("Please enter a number:");
            currentNumber = scanner.nextDouble();

            //Stop getting numbers if entered number is negative
            if (currentNumber>=0) {
                numbers.add(currentNumber);
            }
        }
        scanner.close();
    }

    public double getAverage() {
        //Average = Sum/Number of items
        return getSum()/numbers.size();
    }
    public double getSum() {
        //Loop over and add all to sum
        double sum = 0.0;
        for (int i = 0; i < numbers.size();i++) {
            sum+=numbers.get(i);
        }
        return sum;
    }
    public double getProduct() {
        //Multiply all by product
        double product = 1.0;
        for (int i = 0; i < numbers.size();i++) {
            product*=numbers.get(i);
        }
        return product;
    }
}
