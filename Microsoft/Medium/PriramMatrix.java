import java.util.ArrayList;
import java.util.List;
/* Leetcoe -> 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *  Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *  Output: [1,2,3,6,9,8,7,4,5]
 */
public class PriramMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        // Get the number of rows (n) and columns (m)
        int n = matrix.length, m = matrix[0].length;

        // Initialize boundaries for the current layer of spiral
        int startRow = 0;
        int startCol = 0;
        int endRow = n - 1;
        int endCol = m - 1;

        // Loop until the entire matrix is traversed in spiral order
        while (startRow <= endRow && startCol <= endCol) {

            // Traverse the top row from left to right
            for (int j = startCol; j <= endCol; j++) {
                ans.add(matrix[startRow][j]);
            }

            // Traverse the right column from top to bottom
            for (int i = startRow + 1; i <= endRow; i++) {
                ans.add(matrix[i][endCol]);
            }

            // Traverse the bottom row from right to left (only if not the same as top row)
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break; // Avoid duplicate row
                }
                ans.add(matrix[endRow][j]);
            }

            // Traverse the left column from bottom to top (only if not the same as right
            // column)
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break; // Avoid duplicate column
                }
                ans.add(matrix[i][startCol]);
            }

            // Move to the next inner layer of the matrix
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return ans; // Return the spiral-ordered list
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, 
                            { 5, 6, 7, 8 }, 
                            { 9, 10, 11, 12 } };
        System.out.println(spiralOrder(matrix));
    }
}
