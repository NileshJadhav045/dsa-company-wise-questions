// package Amazon.Easy.Medium;
/* leetcode -> 658. Find K Closest Elements
 * Given a sorted integer array arr, two integers k and x, return the k 
 * closest integers to x in the array. The result should also be sorted in
 * ascending order.

        An integer a is closer to x than an integer b if:

        |a - x| < |b - x|, or
        |a - x| == |b - x| and a < b
    
    Example 1:

        Input: arr = [1,2,3,4,5], k = 4, x = 3

        Output: [1,2,3,4]
 */
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthClosestEle {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Iterate through the array
        for (int ele : arr) {
            if (k > 0) {
                // Initially add the first k elements to the heap
                pq.offer(ele);
                k--;
            } else if (Math.abs(pq.peek() - x) > Math.abs(ele - x)) {
                // If current element is closer to x than the farthest in the heap
                pq.poll(); // Remove the element that's less close
                pq.offer(ele); // Add the new closer element
            }
            // Else, ignore current element as it's not closer
        }
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        return list;
    }
    public static void main(String[] args) {
        int  arr[] = {1,1,2,3,4,5};
        int k = 4, x = -1;
        System.out.println(findClosestElements(arr, k, x));
    }
}
