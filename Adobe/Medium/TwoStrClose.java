import java.util.Arrays;

public class TwoStrClose {
    /* Leetcode -> 1657. Determine if Two Strings Are Close
     * Two strings are considered close if you can attain one from the other using
     * the following operations:
     * Operation 1: Swap any two existing characters.
     * For example, abcde -> aecdb
     * Operation 2: Transform every occurrence of one existing character into
     * another existing character, and do the same with the other character.
     * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into
     * a's)
     * You can use the operations on either string as many times as necessary.
     * 
     * Given two strings, word1 and word2, return true if word1 and word2 are close,
     * and false otherwise.
     */
    public static boolean closeStrings(String word1, String word2) {

        // Step 1: If lengths differ, they can’t be close
        if (word1.length() != word2.length())
            return false;

        // Arrays to store frequency of each character (a-z)
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Step 2: Count character frequencies for word1
        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
        }

        // Step 3: Count character frequencies for word2
        for (int i = 0; i < word2.length(); i++) {
            freq2[word2.charAt(i) - 'a']++;
        }

        // Step 4: Ensure both words have the exact same set of characters
        // (If one word has a character that the other doesn't, return false)
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // Step 5: Sort frequency arrays
        // This allows us to compare if frequencies can be rearranged to match
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        // Step 6: Compare sorted frequencies (content comparison, not reference)
        return Arrays.equals(freq1, freq2);
    }

    public static void main(String[] args) {
        String word1 = "abc", word2 = "bca";
        System.out.println(closeStrings(word1, word2));
    }
}
