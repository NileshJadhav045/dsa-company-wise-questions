import java.util.Collections;
import java.util.PriorityQueue;

/* Leetcode -> 324. Wiggle Sort II
 * Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

    You may assume the input array always has a valid answer.
 */
public class WiggleSortII {
    public static void wiggleSort(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums)
            pq.offer(num);

        // Fill odd indices with largest elements first
        for (int i = 1; i < n; i += 2) {
            nums[i] = pq.poll();
        }
        // Fill even indices with remaining smaller elements
        for (int i = 0; i < n; i += 2) {
            nums[i] = pq.poll();
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 1, 1, 6, 4 };
        wiggleSort(nums);
        for (int idx = 0; idx < nums.length; idx++) {
            System.out.print(nums[idx] + " ");
        }
    }
}
