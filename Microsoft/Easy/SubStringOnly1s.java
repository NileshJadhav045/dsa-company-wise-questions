package Microsoft.Easy;

/* Leetcode -> 1513. Number of Substrings With Only 1s
 * Given a binary string s, return the number of substrings with all characters 1's. 
 * Since the answer may be too large, return it modulo 109 + 7.
 */
public class SubStringOnly1s {
    public static int numSub(String s) {
        long count = 0;
        long ans = 0;
        long mod = 1000000007L;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                // For a block of '1's, the number of substrings = count * (count + 1) / 2
                long add = (count * (count + 1)) / 2;
                add %= mod; // Apply modulo
                ans = (ans + add) % mod; // Add to answer
                count = 0; // Reset count after a '0'
            }
        }
        // Add remaining '1' block at the end (if any)
        long add = (count * (count + 1)) / 2;
        add %= mod;
        ans = (ans + add) % mod;
        return (int)ans;
    }

    public static void main(String[] args) {
        String s = "0110111";
        System.out.println(numSub(s));
    }
}
