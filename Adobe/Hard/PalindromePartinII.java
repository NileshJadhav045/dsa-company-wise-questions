public class PalindromePartinII {
    /* Leetcode -> 132. Palindrome Partitioning II
     * Given a string s, partition s such that every substring of the partition is a palindrome.

        Return the minimum cuts needed for a palindrome partitioning of s.
     */
    public static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        boolean[][] isPal = new boolean[n][n];

        // Precompute palindrome substrings
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }

        // Fill dp array using the precomputed isPal table
        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPal[i][j]) {
                    min = Math.min(min, 1 + dp[j + 1]);
                }
            }
            dp[i] = min;
        }

        return dp[0] - 1; // Subtract 1 because no cut is needed if the whole string is a palindrome
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }
}
