import java.util.*;
/* Leetcode -> 821. Shortest Distance to a Character
    Given a string s and a character c that occurs in s, return an array of integers 
    answer where answer.length == s.length and answer[i] is the distance from index i 
    to the closest occurrence of character c in s.

    The distance between two indices i and j is abs(i - j), where abs is the absolute 
    value function.

    Example 1:
        Input: s = "loveleetcode", c = "e"
        Output: [3,2,1,0,1,0,0,1,2,2,1,0]
        Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
        The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
        The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
        For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
        The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
*/
public class ShortDisToChar {
    public static List<Integer> shortestToChar(String s, char c) {  //O(n^2)
        List<Integer> ans=new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                index.add(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int min_dis = Integer.MAX_VALUE;
            for (int x : index) {
                min_dis = Math.min(Math.abs(x - i), min_dis);
            }
            ans.add(min_dis);
        }
        return ans;
    }

    public static int[] shortestToChar1(String s, char c) { //O(n)
        int n = s.length();
        int[] result = new int[n];
        int prev = Integer.MIN_VALUE / 2;

        // Pass 1: Left to Right
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = i - prev;
        }

        // Pass 2: Right to Left
        prev = Integer.MAX_VALUE / 2;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = Math.min(result[i], prev - i);
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(shortestToChar(s, c));
    }
}
