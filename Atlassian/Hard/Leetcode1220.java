
public class Leetcode1220 {
    /* Leetcode -> 1220. Count Vowels Permutation
     * Given an integer n, your task is to count how many strings of length n can be
     * formed under the following rules:
     * 
     * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
     * Each vowel 'a' may only be followed by an 'e'.
     * Each vowel 'e' may only be followed by an 'a' or an 'i'.
     * Each vowel 'i' may not be followed by another 'i'.
     * Each vowel 'o' may only be followed by an 'i' or a 'u'.
     * Each vowel 'u' may only be followed by an 'a'.
     * Since the answer may be too large, return it modulo 10^9 + 7.
     */
    public static int countVowelPermutation(int n) {
        // Initial count for strings of length = 1
        long aCount = 1; // ending with 'a'
        long eCount = 1; // ending with 'e'
        long iCount = 1; // ending with 'i'
        long oCount = 1; // ending with 'o'
        long uCount = 1; // ending with 'u'

        int mod = 1000000007; // modulus to avoid overflow

        // Build DP counts for lengths 2 → n
        for (int len = 2; len <= n; len++) {
            // Transition rules based on problem statement:
            // 'a' can only follow 'e', 'i', 'u'
            long aCountNew = (eCount + iCount + uCount) % mod;

            // 'e' can only follow 'a', 'i'
            long eCountNew = (aCount + iCount) % mod;

            // 'i' can only follow 'e', 'o'
            long iCountNew = (eCount + oCount) % mod;

            // 'o' can only follow 'i'
            long oCountNew = iCount % mod;

            // 'u' can only follow 'i', 'o'
            long uCountNew = (iCount + oCount) % mod;

            // Update old counts for next iteration
            aCount = aCountNew;
            eCount = eCountNew;
            iCount = iCountNew;
            oCount = oCountNew;
            uCount = uCountNew;
        }

        // Final answer = sum of all valid strings ending with any vowel
        long ans = (aCount + eCount + iCount + oCount + uCount) % mod;
        return (int) ans;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(countVowelPermutation(n));
    }
}
