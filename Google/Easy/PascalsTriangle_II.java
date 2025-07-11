package Google.Easy;

import java.util.ArrayList;
import java.util.List;

/* Leetcode -> 119. Pascal's Triangle II
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
    In Pascal's triangle, each number is the sum of the two numbers 
    directly above it as shown:
 */
public class PascalsTriangle_II {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 1; j < ans.size(); j++) {
                newRow.add(ans.get(j - 1) + ans.get(j));
            }
            newRow.add(1);
            ans = newRow;
        }
        return ans;
    }
    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(getRow(rowIndex));
    }
}
