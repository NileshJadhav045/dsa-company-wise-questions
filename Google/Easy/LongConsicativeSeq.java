package Google.Easy;
/* Leetcode -> 674. Longest Continuous Increasing Subsequence
 * Given an unsorted array of integers nums, return the length of the longest continuous 
 * increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.

    A continuous increasing subsequence is defined by two indices l and r (l < r) 
    such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each 
    l <= i < r, nums[i] < nums[i + 1].


 */
public class LongConsicativeSeq {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int max = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            // If current number is greater than previous, continue the streak
            if (nums[i] > nums[i - 1]) {
                count++;
                max = Math.max(max, count);
            } else {
                // Reset count if the sequence breaks
                count = 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 5, 4, 7 };
        System.out.println(findLengthOfLCIS(nums));
    }
}
