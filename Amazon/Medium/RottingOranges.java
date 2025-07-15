import java.util.LinkedList;
import java.util.Queue;

/* Leetcode -> 994. Rotting Oranges
 * 
 * You are given an m x n grid where each cell can have one of three values:

        0 representing an empty cell,
        1 representing a fresh orange, or
        2 representing a rotten orange.
        Every minute, any fresh orange that is 4-directionally adjacent to 
        a rotten orange becomes rotten.

        Return the minimum number of minutes that must elapse until no cell 
        has a fresh orange. If this is impossible, return -1.
 */
public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count_fresh = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j }); // Add initial rotten oranges to queue
                }
                if (grid[i][j] != 0) {
                    count_fresh++; // Count all fresh and rotten oranges
                }
            }
        }
        if (count_fresh == 0)
            return 0;
        int countmin = 0; // Time in minutes
        int cnt = 0; // Count of oranges that have become rotten (including initially rotten)

        // Direction vectors for 4 adjacent cells (up, down, left, right)
        int dx[] = { 0, 0, 1, -1 };
        int dy[] = { 1, -1, 0, 0 };

        // BFS traversal
        while (!q.isEmpty()) {
            int size = q.size();
            cnt += size; // Add current level's rotten oranges to total count
            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= row || y >= col ||
                            grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    } else { // Mark fresh orange as rotten and add to queue
                        grid[x][y] = 2;
                        q.offer(new int[] { x, y });
                    }
                }
            }
            // Increment minute counter if there are still oranges to process
            if (q.size() != 0) {
                countmin++;
            }
        }
        // If all non-empty cells were processed (rotted), return time, else -1
        return count_fresh == cnt ? countmin : -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println("Total Time is: "+orangesRotting(grid));
    }
}
