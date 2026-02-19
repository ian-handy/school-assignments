//Ian Handy 10/27/25
import java.io.*;

public class MainClass {
    public static void main(String[] args) throws Exception {
        try {PrintWriter printWriter = new PrintWriter(new FileWriter("results.txt",true));
            RunningTotal numbers = new RunningTotal();
            numbers.getNumbersFromUser();
            printWriter.println("Average: " +numbers.getAverage());
            printWriter.println("Product: " +numbers.getProduct());
            printWriter.println("Sum: " + numbers.getSum());
            printWriter.close();
    } catch (IOException e) {System.out.println("Error creating file.");}
}
}
