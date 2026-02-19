//Displays results to screen
public class OutputModule {

    public static void displayResults(AlphabetizerModule alphabetizer) {

        System.out.println("\nOutput\n");

        int count = alphabetizer.getSortedLineCount();

        if (count == 0) {
            System.out.println("\nNo lines to display.\n");
            return;
        }

        // Display each sorted line
        for (int i = 0; i < count; i++) {
            String line = alphabetizer.getSortedLine(i);
            System.out.println(line);
        }

        System.out.println("\nTotal lines: " + count);
    }
}
