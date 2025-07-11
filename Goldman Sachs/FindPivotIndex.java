// package Goldman Sachs;
/* Leetcode -> 724. Find Pivot Index
 * Given an array of integers nums, calculate the pivot index of this array.

    The pivot index is the index where the sum of all the numbers strictly to the 
    left of the index is equal to the sum of all the numbers strictly to the index's right.

    If the index is on the left edge of the array, then the left sum is 0 because there 
    are no elements to the left. This also applies to the right edge of the array.

    Return the leftmost pivot index. If no such index exists, return -1.
 * 
 */
public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int ls = 0, rs = 0, ts = 0;
        for (int i = 0; i < nums.length; i++) {
            ts += nums[i]; // Step 1: Calculate total sum
        }

        // Step 2: Iterate and find pivot index
        for (int i = 0; i < nums.length; i++) {
            rs = ts - ls - nums[i]; // Right sum = total - left - current
            if (ls == rs) {
                return i; // Pivot found
            } else {
                ls += nums[i]; // Update left sum
            }
        }
        return -1; // No pivot found
    }

    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        System.out.println("Pivot index Id: " + pivotIndex(nums));
    }
}
