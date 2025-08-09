import java.util.PriorityQueue;

public class SlidingWindMax {
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // Sort in descending order of value (max-heap)
            return p2.val - this.val;
        }
    }

    public static void maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // Step 1: Add first 'k' elements to the heap
        for (int i = 0; i < k; i++) {
            pq.offer(new Pair(nums[i], i));
        }
        // First window's maximum
        res[0] = pq.peek().val;

        // Step 2: Slide the window
        for (int i = k; i < n; i++) {
            // Remove elements from the heap that are outside the current window
            while ((!pq.isEmpty()) && (pq.peek().idx <= (i - k))) {
                pq.remove();
            }
            // Add the new element (value + index)
            pq.offer(new Pair(nums[i], i));
            // Max element for the current window is at the top of the heap
            res[i - k + 1] = pq.peek().val;
        }
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        maxSlidingWindow(nums, k);
    }
}
