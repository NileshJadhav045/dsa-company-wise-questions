import java.util.HashMap;
import java.util.Map;
/* Leetcode -> 1297. Maximum Number of Occurrences of a Substring
 * Given a string s, return the maximum number of occurrences of any substring
 * under the following rules:
 * 
 * The number of unique characters in the substring must be less than or equal
 * to maxLetters.
 * The substring size must be between minSize and maxSize inclusive.
 */
public class Leetcode1297 {
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        Map<Character, Integer> charCount = new HashMap<>();
        Map<String, Integer> freqMap = new HashMap<>();

        // First window
        for (int i = 0; i < minSize; i++) {
            char c = s.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        if (charCount.size() <= maxLetters) {
            String sub = s.substring(0, minSize);
            freqMap.put(sub, 1);
        }

        int ans = freqMap.isEmpty() ? 0 : 1;

        // Sliding window
        for (int i = minSize; i < n; i++) {
            char removeChar = s.charAt(i - minSize);
            // Remove old char
            if (charCount.get(removeChar) == 1) {
                charCount.remove(removeChar);
            } else {
                charCount.put(removeChar, charCount.get(removeChar) - 1);
            }

            // Add new char
            char addChar = s.charAt(i);
            charCount.put(addChar, charCount.getOrDefault(addChar, 0) + 1);

            if (charCount.size() <= maxLetters) {
                String sub = s.substring(i - minSize + 1, i + 1);
                int count = freqMap.getOrDefault(sub, 0) + 1;
                freqMap.put(sub, count);
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aababcaab";
        int maxLetters = 2, minSize = 3, maxSize = 4;
        System.out.println(maxFreq(s, maxLetters, minSize, maxSize));
    }
}
