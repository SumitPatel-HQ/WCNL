// Time complexity: O(m*n) where m is length of pattern and n is length of text.
// Worst case occurs when characters of pattern and text match but the last character mismatches.
import java.util.ArrayList;
import java.util.List;

class NaiveStringMatching {
    List<Integer> search(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int textLength = text.length();
        int patternLength = pattern.length();
        
        if (pattern == null || text == null || patternLength == 0 || textLength < patternLength) {
            return positions;
        }
        
        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;
            for (j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == patternLength) {
                positions.add(i);
            }
        }
        
        return positions;
    }

    void printResults(String text, String pattern, List<Integer> positions) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("            NAIVE STRING MATCHING RESULTS");
        System.out.println("=".repeat(60) + "\n");
        
        if (positions.isEmpty()) {
            System.out.println("  Pattern not found in the text.\n");
            return;
        }
        
        System.out.println("  Text:    " + text);
        System.out.println("  Pattern: " + pattern + "\n");
        System.out.println("  Pattern found at " + positions.size() + " position(s):\n");
        
        for (int pos : positions) {
            System.out.print("  Position " + pos + ": ");
            
            for (int i = Math.max(0, pos - 5); i < Math.min(text.length(), pos + pattern.length() + 5); i++) {
                if (i == pos) {
                    System.out.print("[");
                }
                System.out.print(text.charAt(i));
                if (i == pos + pattern.length() - 1) {
                    System.out.print("]");
                }
            }
            System.out.println();
        }
        
        System.out.println("\n" + "-".repeat(60));
    }

    public static void main(String[] args) {
        NaiveStringMatching naiveMatch = new NaiveStringMatching();
        
        System.out.println("\nNAIVE STRING MATCHING ALGORITHM");
        System.out.println("-".repeat(35) + "\n");
        
        String text = "ABABABCABABABCABABABC";
        String pattern = "ABABC";
        System.out.println("Using default: Text=\"" + text + "\", Pattern=\"" + pattern + "\"");
        
        System.out.println("\nPerforming search...");
        
        long startTime = System.nanoTime();
        List<Integer> positions = naiveMatch.search(text, pattern);
        long endTime = System.nanoTime();
        
        naiveMatch.printResults(text, pattern, positions);
        
        double executionTimeMs = (endTime - startTime) / 1_000_000.0;
        System.out.println("  Execution time: " + String.format("%.6f", executionTimeMs) + " ms");
        System.out.println("\n" + "*".repeat(60) + "\n");
    }
}
