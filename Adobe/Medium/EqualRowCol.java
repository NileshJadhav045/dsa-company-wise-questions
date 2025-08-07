import java.util.Arrays;
/* Leetcode -> 2352. Equal Row and Column Pairs
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs 
 * (ri, cj) such that row ri and column cj are equal.

    A row and column pair is considered equal if they contain the same elements 
    in the same order (i.e., an equal array).
 */
public class EqualRowCol {
    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        int mat[][] = transpose(grid);
        int count = 0;
        // Compare every row in the original matrix with every row in the transposed
        // matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // If a row in the original matrix matches a column (now row in transpose),
                // count it
                if (Arrays.equals(grid[i], mat[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[][] transpose(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int transpose[][] = new int[n][m];
        // Fill the transpose matrix: switch rows with columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transpose[i][j] = grid[j][i];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        int[][] grid = { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } };
        System.out.println(equalPairs(grid));
    }
}
