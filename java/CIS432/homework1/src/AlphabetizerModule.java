//Sorts shifted lines

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphabetizerModule {
    private List<String> sortedLines;

    public AlphabetizerModule() {
        this.sortedLines = new ArrayList<>();
    }

    public void alphabetize(CircularShiftModule shiftModule) {
        sortedLines.clear();

        // Get all shifted lines
        sortedLines.addAll(shiftModule.getAllShiftedLines());

        // Sort alphabetically (case-insensitive)
        Collections.sort(sortedLines, String.CASE_INSENSITIVE_ORDER);
    }

    public String getSortedLine(int index) {
        if (index >= 0 && index < sortedLines.size()) {
            return sortedLines.get(index);
        }
        return null;
    }

    public int getSortedLineCount() {
        return sortedLines.size();
    }

    public List<String> getAllSortedLines() {
        return new ArrayList<>(sortedLines);
    }
}
