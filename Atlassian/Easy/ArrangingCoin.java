package Atlassian.Easy;
/* Leetcode -> 441. Arranging Coins 
 * You have n coins and you want to build a staircase with these coins.
 *  The staircase consists of k rows where the ith row has exactly i coins. 
 * The last row of the staircase may be incomplete.

    Given the integer n, return the number of complete rows of the staircase you 
    will build.
 */

public class ArrangingCoin {
    public static int arrangeCoins(int n) {
        // return (int)(Math.sqrt(2 * n + 0.25) - 0.5);
        long low = 0, high = n;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long curr = mid * (mid + 1) / 2; // Total coins needed for mid rows

            if (curr == n) {
                return (int) mid; // Exact match
            } else if (curr < n) {
                low = mid + 1; // Try more rows
            } else {
                high = mid - 1; // Too many coins, reduce rows
            }
        }

        return (int) high; // Highest row count that fits within n coins
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(arrangeCoins(n));
    }
}
