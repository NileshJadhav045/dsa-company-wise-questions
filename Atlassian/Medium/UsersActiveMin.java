package Atlassian.Medium;

import java.util.HashMap;
import java.util.HashSet;
/* Leetcode -> 1817. Finding the Users Active Minutes
 * You are given the logs for users' actions on LeetCode, and an integer k. 
 * The logs are represented by a 2D integer array logs where each 
 * logs[i] = [IDi, timei] indicates that the user with IDi performed an 
 * action at the minute timei.

    Multiple users can perform actions simultaneously, and a single user can 
    perform multiple actions in the same minute.

    The user active minutes (UAM) for a given user is defined as the number 
    of unique minutes in which the user performed an action on LeetCode. 
    A minute can only be counted once, even if multiple actions occur during it.

    You are to calculate a 1-indexed array answer of size k such that, 
    for each j (1 <= j <= k), answer[j] is the number of users whose UAM equals j.

    Return the array answer as described above.
 */
public class UsersActiveMin {

    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        // Initialize result array where ans[i] represents the number of users with i+1
        // active minutes
        int ans[] = new int[k];

        // HashMap to track each user's unique active minutes (timestamps)
        HashMap<Integer, HashSet<Integer>> track = new HashMap<>();

        // Iterate through each log entry
        for (int[] log : logs) {
            int id = log[0]; // User ID
            int timestamp = log[1]; // Activity timestamp

            // If user ID not already tracked, initialize with an empty set
            if (!track.containsKey(id)) {
                track.put(id, new HashSet<>());
            }

            // Add timestamp to the user's set to ensure uniqueness
            track.get(id).add(timestamp);
        }

        // Iterate through each user's set of timestamps
        for (int key : track.keySet()) {
            int UAM = track.get(key).size(); // Unique Active Minutes for this user

            // Increment the count of users with this UAM
            // UAM - 1 because array is 0-indexed (UAM of 1 maps to ans[0], etc.)
            ans[UAM - 1]++;
        }

        // Return the result array
        return ans;
    }

    public static void main(String[] args) {
        int[][] logs = { { 0, 5 }, { 1, 2 }, { 0, 2 }, { 0, 5 }, { 1, 3 } };
        int k = 5;
        int ans[] = findingUsersActiveMinutes(logs, k);
        for (int i : ans) {
            System.out.print(i+" ");
        }

    }
}
