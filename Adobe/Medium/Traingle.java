import java.util.ArrayList;
import java.util.List;
/* Leetcode -> 120. Triangle
 * Given a triangle array, return the minimum path sum from top to bottom.
    For each step, you may move to an adjacent number of the row below. More formally, 
    if you are on index i on the current row, you may move to either index i or index 
    i + 1 on the next row.
 */
public class Traingle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Initialize a DP list with the last row of the triangle (base case)
        ArrayList<Integer> dp = new ArrayList<>(triangle.get(n - 1));

        // Start from the second last row and move upwards
        for (int i = n - 2; i >= 0; i--) {
            // For each element in the current row
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // Compute the minimum path sum for the current element
                // by taking the minimum of the two adjacent numbers from the row below
                int current = Math.min(dp.get(j), dp.get(j + 1)) + triangle.get(i).get(j);

                // Update the DP list in-place
                dp.set(j, current);
            }
        }

        // The top of the triangle now contains the minimum path sum
        return dp.get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 1));
        triangle.add(List.of(4, 1, 8, 3));
        int minTotal = minimumTotal(triangle);
        System.out.println(minTotal);
    }
}
