import java.util.List;
//Manages KWIC Index System

public class Main {

    public static void main(String[] args) {
        try {
            //Read lines from keyboard using Input Module
            System.out.println("KWIC Index System\n");

            List<String> inputLines = InputModule.readLines();

            //Check if any lines were entered
            if (inputLines.isEmpty()) {
                System.out.println("No input provided. Exiting.");
                return;
            }

            //Store lines in Line Storage Module
            LineStorageModule lineStorage = new LineStorageModule();
            lineStorage.storeLines(inputLines);

            System.out.println("\nProcessing " + lineStorage.getLineCount() + " line(s)...");

            //Generate circular shifts using Circular Shift Module
            CircularShiftModule shiftModule = new CircularShiftModule();
            shiftModule.generateShifts(lineStorage);

            System.out.println("Generated " + shiftModule.getShiftedLineCount() + " circular shift(s)...");

            //Alphabetize the shifted lines using Alphabetizer Module
            AlphabetizerModule alphabetizer = new AlphabetizerModule();
            alphabetizer.alphabetize(shiftModule);

            System.out.println("Sorted lines alphabetically...");

            //Display results using Output Module
            OutputModule.displayResults(alphabetizer);

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
