import java.io.*;
import java.util.StringTokenizer;

public class JankleBobitProgram {
	
	public static void main(String[] args)  {
        String inputString = "";
        int month = 1, day = 1, year = 20006;
        JankleBobit appointment = new JankleBobit();
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));

        while(true){

            System.out.print("Input the date in the format of MM/DD/YYYY (enter \"q\" to quit): ");

            try {
                inputString = stdin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (inputString.length() > 0 &&
                    (inputString.charAt(0) == 'q' || inputString.charAt(0) == 'Q')) {
                System.out.println("Done!");
                System.exit(0);
            }

            StringTokenizer input = new StringTokenizer(inputString,"/");
            try {
                month = Integer.parseInt(input.nextToken());
                day = Integer.parseInt(input.nextToken());
                year = Integer.parseInt(input.nextToken());
            } catch (Exception e) {
                System.out.println("Invalid date! Please try again!");
                continue;
            }

            if (!JankleBobit.isLegitimate(month, day, year)) {
                System.out.println("Invalid date! Please try again!");
            } else {
                appointment = new JankleBobit(month, day, year);
                appointment.display("The input date is: ");
                JankleBobit.advanceDate(appointment);
                appointment.display("The new date is: ");
            }
        }
    }
}
