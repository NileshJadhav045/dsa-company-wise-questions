import java.util.ArrayList;
import java.util.List;
/* Leetcode -> 524. Longest Word in Dictionary through Deleting
 * Given a string s and a string array dictionary, return the longest string in the 
 * dictionary that can be formed by deleting some of the given string characters. 
 * If there is more than one possible result, return the longest word with the smallest 
 * lexicographical order. If there is no possible result, return the empty string.
 */
public class LongestWordInDict {
    public static String findLongestWord(String s, List<String> dictionary) {
        String sb = ""; // Initialize result string as empty

        // Loop through each word in the dictionary
        for (String str : dictionary) {
            // Check if 'str' can be formed by deleting characters from 's'
            if (isLongest(str, s)) {
                // If 'str' is longer than current result or
                // if equal in length but lexicographically smaller, update the result
                if (str.length() > sb.length() ||
                        (str.length() == sb.length() && str.compareTo(sb) < 0)) {
                    sb = str;
                }
            }
        }
        return sb;
    }

    public static boolean isLongest(String x, String y) {
        int j = 0;

        // Traverse through string y
        for (int i = 0; i < y.length() && j < x.length(); i++) {
            // If characters match, move pointer j for string x
            if (x.charAt(j) == y.charAt(i)) {
                j++;
            }
        }

        // If we've matched all characters in x, then it's a subsequence of y
        return j == x.length();
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");
        System.out.println(findLongestWord(s, dictionary));
    }
}
