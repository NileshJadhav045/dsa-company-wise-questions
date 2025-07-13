/* Leetcode -> 541. Reverse String II
 * Given a string s and an integer k, reverse the first k characters for every 
 * 2k characters counting from the start of the string.

        If there are fewer than k characters left, reverse all of them. 
        If there are less than 2k but greater than or equal to k characters, 
        then reverse the first k characters and leave the other as original.
    Example 1:

        Input: s = "abcdefg", k = 2
        Output: "bacdfeg"
 
 */
public class ReverseStr_II {
    public static String reverseStr(String s, int k) {
        int start = 0; // Starting index of the segment to reverse
        int end = Math.min(k, s.length()); // Ending index for the first reverse

        // Convert the string to a character array for in-place modifications
        char[] ch = s.toCharArray();

        // Loop through the string in steps of 2k
        while (start < s.length()) {
            // Reverse characters from index 'start' to 'end - 1'
            reverse(ch, start, end);
            // Move start to the next segment (skip k characters after reversed k)
            start = start + 2 * k;
            // Calculate the new end index, ensuring we don't go out of bounds
            end = Math.min(start + k, s.length());
        }
        return new String(ch);
    }

    public static void reverse(char ch[], int start, int end) {
        while (start < end) {
            // Swap characters at positions 'start' and 'end - 1'
            char temp = ch[start];
            ch[start] = ch[end - 1];
            ch[end - 1] = temp;
            // Move towards the center
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}
