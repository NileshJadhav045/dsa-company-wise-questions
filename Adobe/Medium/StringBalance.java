public class StringBalance {
    /* Leetcode -> 1963. Minimum Number of Swaps to Make the String Balanced
     * You are given a 0-indexed string s of even length n. The string consists of
     * exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
     * 
     * A string is called balanced if and only if:
     * 
     * It is the empty string, or
     * It can be written as AB, where both A and B are balanced strings, or
     * It can be written as [C], where C is a balanced string.
     * You may swap the brackets at any two indices any number of times.
     * 
     * Return the minimum number of swaps to make s balanced.
     * 
     * Input: s = "]]][[["
        Output: 2
        Explanation: You can do the following to make the string balanced:
        - Swap index 0 with index 4. s = "[]][][".
        - Swap index 1 with index 5. s = "[[][]]".
        The resulting string is "[[][]]".
     */
    public static int minSwap(String s) {
        int size = 0; // Tracks the count of unmatched '[' brackets

        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                // Found an opening bracket, increase unmatched count
                size++;
            } else if (size > 0) {
                // Found a closing bracket ']', and there is an unmatched '['
                // so we match them and decrease unmatched count
                size--;
            }
        }

        // The formula (size + 1) / 2 gives the minimum number of swaps needed
        // to balance the brackets
        return (size + 1) / 2;
    }

    public static void main(String[] args) {
        String s = "]]][[[";
        System.out.println(minSwap(s));
    }
}
