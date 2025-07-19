import java.util.Arrays;
import java.util.LinkedList;

/* Leetcode -> 56. Merge Intervals
 * Given an array of intervals where intervals[i] = [starti, endi], merge all 
 * overlapping intervals, and return an array of the non-overlapping intervals 
 * that cover all the intervals in the input.
 * 
 * Example 1:
        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class MargeIntervals {
    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by starting time (ascending)
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        // Step 2: Use a LinkedList to store merged intervals
        LinkedList<int[]> ans = new LinkedList<>();
        // Step 3: Iterate over the intervals
        for (int[] interval : intervals) {
            // Case 1: If ans is empty or there is no overlap, add current interval
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            } else {
                // Case 2: There is an overlap, merge with last interval
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

    public static void main(String[] args) {
        int[][] input = { {1, 3}, {2, 6}, {8, 10}, {15, 18} };
        int[][] merged = merge(input);

        System.out.println("Merged Intervals:");
        printIntervals(merged);
    }
}
