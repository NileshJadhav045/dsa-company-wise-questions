public class MinNumOfSwap {
    /*
     * Leetcod -> 1864. Minimum Number of Swaps to Make the Binary String
     * Alternating
     * Given a binary string s, return the minimum number of character swaps
     * to make it alternating, or -1 if it is impossible.
     * 
     * The string is called alternating if no two adjacent characters are equal. For
     * example, the strings "010" and "1010" are alternating, while the string
     * "0100" is not.
     * 
     * Any two characters may be swapped, even if they are not adjacent.
     * 
     * Example 1:
        Input: s = "111000"
        Output: 1
        Explanation: Swap positions 1 and 4: "111000" -> "101010"
        The string is now alternating.
     */
    public static int minSwaps(String s) {
        int cout0 = 0, cout1 = 0, miss0 = 0, miss1 = 0;
        // Count number of 0s and 1s in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                cout0++;
            } else {
                cout1++;
            }
        }
        // If the difference in count of 0s and 1s is more than 1, it's impossible to alternate
        if (Math.abs(cout0 - cout1) > 1) {
            return -1;
        }

        // Count mismatches at even indices when string is expected to alternate
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != '0') {
                miss0++; // mismatch if expecting '0' at even index
            } else {
                miss1++; // mismatch if expecting '1' at even index
            }
        }
        // If count of 0s and 1s are equal, take minimum of mismatches
        // Else, use mismatch count according to majority character
        return cout0 == cout1 ? Math.min(miss0, miss1) : 
                    cout0 > cout1 ? miss0 : miss1;

    }

    public static void main(String[] args) {
        String str = "111000";
        System.out.println("Minimum Number of swap: "+minSwaps(str));
    }
}
