import java.util.HashMap;
import java.util.Map;
// 560. Subarray Sum Equals K
/*
 * Given an array of integers nums and an integer k, return the total 
 * number of subarrays whose sum equals to k.
  - A subarray is a contiguous non-empty sequence of elements within an array.

  Example 1:
    Input: nums = [1,1,1], k = 2
    Output: 2
 */
public class SubArrSumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        // Map to store cumulative sum frequencies: (sum -> count)
        Map<Integer, Integer> map = new HashMap<>();

        // Base case: sum 0 has occurred once (helps when subarray starts from index 0)
        map.put(0, 1);

        int n = nums.length;
        int ans = 0; // Total number of subarrays that sum to k
        int sum = 0; // Cumulative prefix sum

        // Traverse the array
        for (int i = 0; i < n; i++) {
            sum += nums[i]; // Update running sum

            // Check if there is a previous prefix sum such that: sum - prevSum = k
            if (map.containsKey(sum - k)) {
                // If found, add the frequency of that sum to the answer
                ans += map.get(sum - k);
            }

            // Update the map with current sum's frequency
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans; // Return total count of valid subarrays
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
}
