// package Amazon.Easy.Medium;

/* Leetcode -> 215. Kth Largest Element in an Array
 * Given an integer array nums and an integer k, 
 * return the kth largest element in the array.

    Note that it is the kth largest element in the sorted order, 
    not the kth distinct element.
 */
import java.util.PriorityQueue;

public class KthLargestEle {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : nums) {
            pq.add(x);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    // Simple and Easy
    // public static int findKthLargest(int[] nums, int k) {
    // Arrays.sort(nums);
    // return nums[nums.length - k];

    // }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
