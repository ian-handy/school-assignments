//Generates/stores shitfs

import java.util.ArrayList;
import java.util.List;

public class CircularShiftModule {
    private final List<String> shiftedLines;

    public CircularShiftModule() {
        this.shiftedLines = new ArrayList<>();
    }

    public void generateShifts(LineStorageModule lineStorage) {
        shiftedLines.clear();

        // For each line in storage
        for (int i = 0; i < lineStorage.getLineCount(); i++) {
            int wordCount = lineStorage.getWordCount(i);

            //Generate all circular shifts for this line
            for (int startWord = 0; startWord < wordCount; startWord++) {
                StringBuilder shifted = new StringBuilder();

                //Build shifted line starting from word at position startWord
                for (int j = 0; j < wordCount; j++) {
                    int index = (startWord + j) % wordCount;
                    shifted.append(new String(lineStorage.getWord(i, index)));

                    //Add space between words if word is not last word
                    if (j < wordCount - 1) {
                        shifted.append(" ");
                    }
                }

                shiftedLines.add(shifted.toString());
            }
        }
    }

    public String getShiftedLine(int index) {
        if (index >= 0 && index < shiftedLines.size()) {
            return shiftedLines.get(index);
        }
        return null;
    }

    public int getShiftedLineCount() {
        return shiftedLines.size();
    }

    public List<String> getAllShiftedLines() {
        return new ArrayList<>(shiftedLines);
    }
}
