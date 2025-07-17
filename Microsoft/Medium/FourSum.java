import java.util.*;

/*
 * Given an array nums of n integers, return an array of all the unique quadruplets 
 * [nums[a], nums[b], nums[c], nums[d]] such that:

    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target
    You may return the answer in any order.

    Example 1:
        Input: nums = [1,0,-1,0,-2,2], target = 0
        Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
*/
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        // Three nested loops to fix the first three numbers
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                     // Calculate the required fourth number
                    long newTarget = target;
                    newTarget -= nums[i];
                    newTarget -= nums[j];
                    newTarget -= nums[k];

                     // Perform binary search for the fourth number
                    int start = k + 1;
                    int end = n - 1;
                    while (start <= end) {
                        int mid = start + (end - start) / 2;
                        if (nums[mid] == newTarget) {
                            // If found, create a quadruplet
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[mid]);

                            set.add(list); // Add to set to ensure uniqueness
                            break; // Break after finding a valid quadruplet
                        } else if (nums[mid] < newTarget) {
                            start = mid + 1;
                        } else {
                            end = mid - 1;
                        }
                    }
                }
            }
        }
        // Convert the set of results to a list before returning
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    public static void main(String[] args) {
        int []nums = {1,0,-1,0,-2,2}; 
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
}
