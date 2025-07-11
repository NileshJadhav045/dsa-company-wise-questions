public class NumberOfIsland {
    /* Leetcode -> 200. Number of Islands
     * Given an m x n 2D binary grid grid which represents a map 
     * of '1's (land) and '0's (water), return the number of islands.

        An island is surrounded by water and is formed by connecting 
        adjacent lands horizontally or vertically. You may assume all 
        four edges of the grid are all surrounded by water.
     * 
     */
    public static int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        int noLand = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // If a land cell is found
                if (grid[i][j] == '1') {
                    noLand++; // Count this island
                    DFS(grid, i, j, row, col); // Mark all connected land as visited
                }
            }
        }
        return noLand;
    }

    public static void DFS(char[][] grid, int i, int j, int row, int col) {
        // Check boundary and if the current cell is not land
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') {
            return;
        }
        // Mark current land cell as visited by setting it to '0'
        grid[i][j] = '0';
        // Recursively call DFS in all 4 directions
        DFS(grid, i + 1, j, row, col); // down
        DFS(grid, i - 1, j, row, col); // up
        DFS(grid, i, j + 1, row, col); // right
        DFS(grid, i, j - 1, row, col); // left
    }

    public static void main(String[] args) {
        char[][] grid = { { '1', '1', '1', '1', '0' },
                          { '1', '1', '0', '1', '0' },
                          { '1', '1', '0', '0', '0' },
                          { '0', '0', '0', '0', '0' } };
        System.out.println("Number of Island: " + numIslands(grid));

    }
}
