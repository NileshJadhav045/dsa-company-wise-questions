// package Amazon.Easy.Medium;

/* Leetcode -> 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. 
 * You can return the answer in any order.
 * 
 *      Input: strs = ["eat","tea","tan","ate","nat","bat"]

        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        Explanation:

        There is no string in strs that can be rearranged to form "bat".
        The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
        The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 */
import java.util.*;

public class GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Final answer list to store groups of anagrams
        List<List<String>> ans = new ArrayList<>();

        // Map to group words by their sorted character signature
        HashMap<String, List<String>> map = new HashMap<>();

        // Traverse through all strings in the input array
        for (int i = 0; i < strs.length; i++) {
            // Convert string to character array and sort it
            char ch[] = strs[i].toCharArray();
            Arrays.sort(ch); // Sorting ensures anagrams have the same character order

            // Convert sorted char array back to string
            String s = String.valueOf(ch);

            // If the sorted string is already a key in map, add the original word
            if (map.get(s) != null) {
                List<String> a = map.get(s);
                a.add(strs[i]);
                map.put(s, a); // Update the list in the map
            } else {
                // If not, create a new list and put it in the map
                List<String> a = new ArrayList<>();
                a.add(strs[i]);
                map.put(s, a);
            }
        }

        // Collect all grouped anagrams from the map
        for (Map.Entry<String, List<String>> s : map.entrySet()) {
            ans.add(s.getValue());
        }

        return ans; // Return the list of grouped anagrams
    }

    public static void main(String[] args) {
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }
}
