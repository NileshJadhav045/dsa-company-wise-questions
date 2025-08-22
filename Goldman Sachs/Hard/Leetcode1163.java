/* Leetcode -> 1163. Last Substring in Lexicographical Order
 * Given a string s, return the last substring of s in lexicographical order.
 * Input: s = "abab"
    Output: "bab"
    Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. 
    The lexicographically maximum substring is "bab".
 */
public class Leetcode1163 {
    public static String lastSubstring(String s) {
        // Start by assuming the last character is the beginning of the largest
        // substring
        int maxIdx = s.length() - 1;

        // Traverse string backwards to compare potential starting positions
        for (int currIdx = s.length() - 1; currIdx >= 0; currIdx--) {

            // Case 1: Found a strictly larger character → update maxIdx
            if (s.charAt(currIdx) > s.charAt(maxIdx)) {
                maxIdx = currIdx;

                // Case 2: Characters are equal → need to compare substrings lexicographically
            } else if (s.charAt(currIdx) == s.charAt(maxIdx)) {
                int i = currIdx + 1; // next char after current candidate
                int j = maxIdx + 1; // next char after current best

                // Compare the suffixes character by character
                while (i < maxIdx && j < s.length() && s.charAt(i) == s.charAt(j)) {
                    i++;
                    j++;
                }

                // If we exhausted current candidate or reached string end,
                // OR the next character of current candidate is greater,
                // then update maxIdx
                if (i == maxIdx || j == s.length() || s.charAt(i) > s.charAt(j)) {
                    maxIdx = currIdx;
                }
            }
        }

        // Return the lexicographically largest substring starting from maxIdx
        return s.substring(maxIdx);
    }

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(lastSubstring(s));
    }
}
