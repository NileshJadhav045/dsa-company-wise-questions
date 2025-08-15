import java.util.Arrays;

/* Leetcode -> 526. Beautiful Arrangement

 * Suppose you have n integers labeled 1 through n. A permutation of those n 
 * integers perm (1-indexed) is considered a beautiful arrangement if for every
 * i (1 <= i <= n), either of the following is true:

    - perm[i] is divisible by i.
    - i is divisible by perm[i].

    Given an integer n, return the number of the beautiful arrangements that you 
    can construct.
 */
public class BeautifulArrangement {
    public static int countArrangement(int n) {
        // Create a visited array to track used numbers, index 0 is unused for
        // convenience
        int vis[] = new int[n + 1];
        Arrays.fill(vis, 0); // Initialize all positions as unvisited
        // Start the backtracking process from position 1
        int ans = backtracking(vis, 1, n);
        return ans;
    }

    static int backtracking(int[] vis, int pos, int n) {
        // Base case: if position exceeds n, a valid arrangement is found
        if (pos > n)
            return 1;

        int count = 0;
        // Try placing numbers from 1 to n at current position
        for (int i = 1; i <= n; i++) {
            // Check if the number i is not used and satisfies the beautiful condition
            if (vis[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                vis[i] = 1; // Mark number i as used
                count += backtracking(vis, pos + 1, n); // Recurse for next position
                vis[i] = 0; // Backtrack: unmark number i
            }
        }
        return count; // Return total count of valid arrangements from this position
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(countArrangement(n));
    }
}
