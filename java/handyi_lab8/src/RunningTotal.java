//Ian Handy 10/27/25
import java.io.*;
import java.util.*;

public class RunningTotal {

    ArrayList<Double> numbers = new ArrayList<>();

    public void getNumbersFromUser() {

        try {Scanner scanner = new Scanner(new File("numbers.txt"));
        
        //Get numbers from file
        while (scanner.hasNext()) {
            numbers.add(scanner.nextDouble());
        }
        scanner.close();
    } catch (IOException e) {System.out.println("Error loading file.");}
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
