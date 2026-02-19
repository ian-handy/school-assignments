import java.util.ArrayList;
import java.util.List;

/**
 * Line Storage Module - Responsible for storing original lines.
 * Implements information hiding by encapsulating how lines are stored internally.
 * Words are stored as sequences of characters (Strings).
 */
public class LineStorageModule {
    private List<char[][]> lines;

    /**
     * Constructor initializes the storage.
     */
    public LineStorageModule() {
        this.lines = new ArrayList<>();
    }

    /**
     * Stores a single line as an array of words, each word as a char array.
     * @param line The line to store
     */
    public void storeLine(String line) {
        if (line != null && !line.trim().isEmpty()) {
            String[] words = line.trim().split("\\s+");
            char[][] wordChars = new char[words.length][];
            for (int i = 0; i < words.length; i++) {
                wordChars[i] = words[i].toCharArray();
            }
            lines.add(wordChars);
        }
    }

    /**
     * Stores multiple lines.
     * @param lines List of lines to store
     */
    public void storeLines(List<String> lines) {
        if (lines != null) {
            for (String line : lines) {
                storeLine(line);
            }
        }
    }

    /**
     * Returns the stored line at the specified index as a String.
     * @param index The index of the line
     * @return The line at the given index
     */
    public String getLine(int index) {
        if (index >= 0 && index < lines.size()) {
            char[][] wordChars = lines.get(index);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < wordChars.length; i++) {
                sb.append(new String(wordChars[i]));
                if (i < wordChars.length - 1) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
        return null;
    }

    /**
     * Returns the word at the specified line and word index.
     * @param lineIndex The index of the line
     * @param wordIndex The index of the word
     * @return The word as a char array
     */
    public char[] getWord(int lineIndex, int wordIndex) {
        if (lineIndex >= 0 && lineIndex < lines.size()) {
            char[][] wordChars = lines.get(lineIndex);
            if (wordIndex >= 0 && wordIndex < wordChars.length) {
                return wordChars[wordIndex];
            }
        }
        return null;
    }

    /**
     * Returns the number of words in the specified line.
     * @param lineIndex The index of the line
     * @return Number of words in the line
     */
    public int getWordCount(int lineIndex) {
        if (lineIndex >= 0 && lineIndex < lines.size()) {
            return lines.get(lineIndex).length;
        }
        return 0;
    }

    /**
     * Returns the number of stored lines.
     * @return Number of lines
     */
    public int getLineCount() {
        return lines.size();
    }

    /**
     * Returns all stored lines.
     * @return List of all lines
     */
    public List<String> getAllLines() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            result.add(getLine(i));
        }
        return result;
    }
}
