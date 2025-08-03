

public class FirstMissPosi {
/* Leetcode -> 41. First Missing Positive
 * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

    You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct index position, i.e., nums[i] should
        // be at index nums[i] - 1
        for (int i = 0; i < n; i++) {
            // Only consider values in range [1, n]
            // Also check if target position doesn't already have the correct value to avoid
            // infinite loop
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1); // Place nums[i] at its correct position
            }
        }

        // Step 2: After rearrangement, the first place where nums[i] != i + 1 is the
        // missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // Found the first missing positive
            }
        }

        // Step 3: If all positions are correct, then the missing number is n + 1
        return n + 1;
    }

    
    public static  void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int []nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
    }
}
