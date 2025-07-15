// package Amazon.Easy.Medium;

import java.util.TreeMap;

public class MeethingRoomII {
    public static int minMeetingRooms(int arr[][]) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0, count = 0;
        // For each meeting, increment the count at the start time
        // and decrement it at the end time
        for (int i[] : arr) {
            int start = i[0], end = i[1];
            map.put(start, map.getOrDefault(start, 0) + 1); // meeting starts
            map.put(end, map.getOrDefault(end, 0) - 1);     // meeting ends
        }
        // Traverse through the time points in order
        // Maintain a running count of ongoing meetings
        for (int key : map.keySet()) {
            count += map.get(key);          // update count with net change at this time
            ans = Math.max(ans, count);     // track maximum rooms needed at any time
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println("minimum Meeting Rooms: "+minMeetingRooms(arr));
    }
}
