
public class UniquePathIII {
/* Leetcode -> 980. Unique Paths III
 * You are given an m x n integer array grid where grid[i][j] could be: 
    1 representing the starting square. There is exactly one starting square.
    2 representing the ending square. There is exactly one ending square.
    0 representing empty squares we can walk over.
    -1 representing obstacles that we cannot walk over.
    Return the number of 4-directional walks from the starting square to the ending square, 
    that walk over every non-obstacle square exactly once.
 */
    public static int uniquePathsIII(int[][] grid) {
        int start_x = 0, start_y = 0;
        int zero=1;
        int res;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    start_x = i;
                    start_y = j;
                } else if (grid[i][j] == 0) {
                    zero++;
                }
            }
        }
        res = dfs(grid, start_x, start_y, 0, zero);
        return res;
    }

    public static int dfs(int grid[][], int x, int y, int count, int zero) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1){
            return 0;
        }

        // If destination is reached
        if (grid[x][y] == 2) {
            return count == zero ? 1 : 0; // Valid path only if all empty squares are visited
        }
        int temp = grid[x][y]; // Store current cell value
        grid[x][y] = -1; // Mark current cell as visited
        int totalPaths = 0;

        // Explore all four directions
        totalPaths += dfs(grid, x + 1, y, count + 1, zero);
        totalPaths += dfs(grid, x - 1, y, count + 1, zero);
        totalPaths += dfs(grid, x, y + 1, count + 1, zero);
        totalPaths += dfs(grid, x, y - 1, count + 1, zero);

        grid[x][y] = temp; // Backtrack - restore the cell

        return totalPaths;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } };
        System.out.println(uniquePathsIII(grid));
    }
}
