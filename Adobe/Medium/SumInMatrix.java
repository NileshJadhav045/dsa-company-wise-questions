import java.util.Arrays;

/* Leetcode->2679. Sum in a Matrix
 * You are given a 0-indexed 2D integer array nums. Initially, your score is 0. Perform the following operations until the matrix becomes empty:

        From each row in the matrix, select the largest number and remove it. In the case of a tie, it does not matter which number is chosen.
        Identify the highest number amongst all those removed in step 1. Add that number to your score.
        Return the final score.
 */
public class SumInMatrix {
    public static int matrixSum(int[][] nums) {
        int ans = 0;
        int n = nums.length; 
        int m = nums[0].length;

        // Step 1: Sort each row in ascending order
        for (int[] row : nums) {
            Arrays.sort(row);
        }

        // Step 2: Traverse column by column
        // For each column, pick the maximum value from all rows
        for (int i = 0; i < m; i++) {
            int maxInColumn = 0;
            for (int j = 0; j < n; j++) {
                // Compare and keep the max value from current column
                maxInColumn = Math.max(maxInColumn, nums[j][i]);
            }
            // Add the maximum of each column to the final answer
            ans += maxInColumn;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = { { 7, 2, 1 }, { 6, 4, 2 }, { 6, 5, 3 }, { 3, 2, 1 } };
        System.out.println(matrixSum(nums));
    }
}
