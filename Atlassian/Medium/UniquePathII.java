public class UniquePathII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        // If the destination cell is not an obstacle, set it to 1 as base case
        dp[n - 1][m - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // If the current cell is an obstacle, no paths go through it
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                // If not on the last row, add paths from the cell below
                if (i + 1 < n) {
                    dp[i][j] = dp[i + 1][j];
                }
                // If not on the last column, add paths from the cell to the right
                if (j + 1 < m) {
                    dp[i][j] += dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
