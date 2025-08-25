import java.util.Arrays;

/* Leetcode -> 719. Find K-th Smallest Pair Distance
 * The distance of a pair of integers a and b is defined as the absolute difference between a and b.
    Given an integer array nums and an integer k, return the kth smallest distance among 
    all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.
 */
public class Leetcode719 {
    public static int smallestDistancePair(int[] nums, int k) {
        // Step 1: Sort the array so that we can use two pointers and binary search on
        // distance
        Arrays.sort(nums);
        int n = nums.length;

        // Step 2: Define the search space for the answer
        // Minimum distance = 0 (same elements),
        // Maximum distance = max element - min element
        int l = 0;
        int r = nums[n - 1] - nums[0];

        // Step 3: Binary search to find the k-th smallest distance
        while (l < r) {
            int mid = l + (r - l) / 2; // candidate distance
            int count = 0;

            // Step 4: Count how many pairs have distance <= mid
            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= mid) {
                    j++;
                }
                // For current i, pairs (i, i+1), (i, i+2), ..., (i, j-1) are valid
                count += j - i - 1;
            }

            // Step 5: Adjust binary search bounds
            if (count < k) {
                // If there are fewer than k pairs with distance <= mid,
                // we need to search in the larger half
                l = mid + 1;
            } else {
                // Otherwise, search in the smaller half (including mid)
                r = mid;
            }
        }

        // Step 6: l (or r) will be the k-th smallest distance
        return l;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 1 };
        int k = 1;
        System.out.println(smallestDistancePair(nums, k));
    }
}
