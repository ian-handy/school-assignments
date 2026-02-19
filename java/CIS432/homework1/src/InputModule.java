//Reads lines from keyboard

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputModule {

    //Reads multiple lines from keyboard until an empty line is entered

    public static List<String> readLines() {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter lines of text (press Enter on empty line to finish):");

        while (true) {
            String line = scanner.nextLine().trim();

            //Stop reading when an empty line is encountered
            if (line.isEmpty()) {
                break;
            }

            lines.add(line);
        }

        scanner.close();
        return lines;
    }
}
