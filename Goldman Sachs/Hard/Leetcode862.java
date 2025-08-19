import java.util.*;

public class Leetcode862 {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        // Prefix sum array where p[i] = sum of nums[0..i-1]
        long[] p = new long[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + nums[i];
        }

        // Initialize answer as n+1 (impossible large value)
        int ans = n + 1;

        // Deque to store indices of prefix sums (monotonic queue)
        Deque<Integer> dq = new LinkedList<>();

        // Iterate over all prefix sums
        for (int y = 0; y < p.length; y++) {

            // Maintain increasing order of prefix sums in deque
            // If current prefix sum is smaller than last stored one,
            // remove it, since it won't help in finding shorter subarray
            while (!dq.isEmpty() && p[y] <= p[dq.getLast()]) {
                dq.pollLast();
            }

            // Check if the current prefix sum - smallest prefix sum in deque >= k
            // If yes, update the answer with the possible shorter subarray length
            while (!dq.isEmpty() && p[y] >= p[dq.getFirst()] + k) {
                ans = Math.min(ans, y - dq.pollFirst());
            }

            // Add current index to deque
            dq.addLast(y);
        }

        // If ans is still greater than n, it means no valid subarray was found
        return ans <= n ? ans : -1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, -1, 2 };
        int k = 3;
        System.out.println(shortestSubarray(nums, k));
    }
}
