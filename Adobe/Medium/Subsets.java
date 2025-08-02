
import java.util.ArrayList;
import java.util.List;
/* Leetcode -> 78. Subsets
 * Given an integer array nums of unique elements, return all possible subsets (the power set).

    The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    // Helper method for backtracking
    private static void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> res) {
        // Add a copy of the current subset to the result
        res.add(new ArrayList<>(current));

        // Iterate through the remaining elements
        for (int i = index; i < nums.length; i++) {
            // Include nums[i] in the current subset
            current.add(nums[i]);

            // Recurse with the next index
            backtrack(i + 1, nums, current, res);

            // Backtrack: remove the last element before exploring the next option
            current.remove(current.size() - 1);
        }
    }

    public static  List<List<Integer>> subsets1(int[] nums) {
        // Create a list to store all subsets (starting with an empty subset)
        List<List<Integer>> subs = new ArrayList<>();
        subs.add(new ArrayList<>()); // Add empty subset initially

        // Iterate through each number in the input array
        for (int num : nums) {
            int n = subs.size(); // Get current number of subsets

            // For each existing subset, create a new subset by adding the current number
            for (int i = 0; i < n; i++) {
                // Create a copy of the i-th subset
                ArrayList<Integer> list = new ArrayList<>(subs.get(i));

                // Add the current number to this copy
                list.add(num);

                // Add the new subset to the list of all subsets
                subs.add(list);
            }
        }

        // Return the complete list of all subsets
        return subs;
    }

    public static void main(String[] args) {
        int []nums = {1,2,3};
        System.out.println(subsets1(nums));
    }
}
