import java.util.ArrayList;
import java.util.List;
/* Leetcode -> 46. Permutations
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */
public class Permutaions {
    static List<List<Integer>> ans;

    public static List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        helper(nums, new ArrayList<>());
        return ans;
    }

    public static void helper(int[] nums, ArrayList<Integer> list) {
        // Base case: if the current list has all elements, it's a valid permutation
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list)); // Make a deep copy before adding
            return;
        }
        // Try each number that hasn't been used yet
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -12) { // Use -12 as a marker for visited
                int temp = nums[i];
                list.add(temp); // Choose the number
                nums[i] = -12; // Mark as used
                helper(nums, list); // Recurse
                list.remove(list.size() - 1); // Backtrack: remove last added
                nums[i] = temp; // Restore original value
            }
        }
    }

    public static void main(String[] args) {
        int []nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
