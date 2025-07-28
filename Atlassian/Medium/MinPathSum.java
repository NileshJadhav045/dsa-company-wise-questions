public class MinPathSum {
    /*
     * Leetcode -> 64. Minimum Path Sum
     * Given a m x n grid filled with non-negative numbers, find a path from top
     * left to bottom right, which minimizes the sum of all numbers along its path.
     * 
     * Note: You can only move either down or right at any point in time.
     * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
     * Output: 7
     * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     */
    public static int minPathSum(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        // Fill the first row by accumulating sums from left to right
        for (int j = 1; j < m; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // Fill the first column by accumulating sums from top to bottom
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // Fill the rest of the grid with the minimum path sum to each cell
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // Take the minimum of the top or left cell and add to current cell
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        // The bottom-right cell contains the minimum path sum from top-left
        return grid[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println("Minimum Path Sum is: " + minPathSum(grid));
    }
}
