
import java.util.ArrayList;
import java.util.List;

/* Leetoce -> 934. Shortest Bridge
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
    An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
    You may change 0's to 1's to connect the two islands to form one island.
    Return the smallest number of 0's you must flip to connect the two islands.
 */
public class ShortestBridge {

    static List<int[]> q;

    public static void dfs(int[][] grid, int x, int y) {
        int n = grid.length, m = grid[0].length;
        grid[x][y] = 2; // mark island
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        boolean isBorder = false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (grid[nx][ny] == 1) {
                    dfs(grid, nx, ny);
                } else if (grid[nx][ny] == 0) {
                    isBorder = true; // touches water
                }
            }
        }

        // only enqueue border cells
        if (isBorder) {
            q.add(new int[]{0, x, y});
        }
    }

    public static int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        q = new ArrayList<>();

        // Step 1: DFS to mark first island
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < m && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    found = true;
                }
            }
        }

        // Step 2: BFS expansion
        while (!q.isEmpty()) {
            List<int[]> newQ = new ArrayList<>();
            for (int[] curr : q) {
                int wt = curr[0], x = curr[1], y = curr[2];
                int dx[] = {1, -1, 0, 0};
                int dy[] = {0, 0, 1, -1};
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k], ny = y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if (grid[nx][ny] == 1) {
                            return wt;
                        } else if (grid[nx][ny] == 0) {
                            newQ.add(new int[]{wt + 1, nx, ny});
                            grid[nx][ny] = -1;
                        }
                    }
                }
            }
            q = newQ;
        }
        return -1;
    }

    public static void main(String[] args) {
        int grid[][] = {{0, 1}, {1, 0}};
        System.out.println(shortestBridge(grid));
    }
}
