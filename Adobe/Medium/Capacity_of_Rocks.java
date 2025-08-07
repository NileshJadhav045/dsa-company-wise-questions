import java.util.PriorityQueue;

/* Leetcode -> 2279. Maximum Bags With Full Capacity of Rocks
 * You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks. 
 * The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks. 
 * You are also given an integer additionalRocks, the number of additional rocks you can place in any of the bags.

    Return the maximum number of bags that could have full capacity after placing the additional rocks in some bags.
 */
public class Capacity_of_Rocks {
    // public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    //     int n = capacity.length;
    //     List<Integer> diff = new ArrayList<>();
    //     // Calculate the difference between capacity and current rocks for each bag
    //     int ans = 0;
    //     // Sort the differences in ascending order so we can fill the easiest (least rocks needed) bags first
    //     for (int i = 0; i < n; i++) {
    //         diff.add(capacity[i] - rocks[i]);
    //     }
    //     Collections.sort(diff);
    //      // Iterate through the sorted differences and try to fill as many bags as possible
    //     for (int i = 0; i < n; i++) {
    //         // If we have enough additional rocks to fill the current bag
    //         if (diff.get(i) <= additionalRocks) {
    //             additionalRocks = additionalRocks - diff.get(i); // Use the required rocks
    //             ans++; // Increment the count of fully filled bags
    //         }
    //     }
    //     return ans;
    // }

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        PriorityQueue<Integer> diff = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            diff.offer(capacity[i] - rocks[i]);
        }

        while (!diff.isEmpty() && diff.peek() <= additionalRocks) {
           additionalRocks -= diff.poll();
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] capacity = { 2, 3, 4, 5 };
        int[] rocks = { 1, 2, 4, 4 };
        int additionalRocks = 2;
        System.out.println(maximumBags(capacity, rocks, additionalRocks));
    }
}
