import java.util.*;

public class K_diff {
    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int ans = 0;
        // Iterate through all unique numbers (keys) in the map
        for (int key : map.keySet()) {
            // Special case: looking for duplicates (a - a = 0)
            if (k == 0) {
                if (map.get(key) > 1) {
                    ans++;
                }
            } else {
                // For k > 0, check if there is a number such that key + k exists
                if (map.containsKey(key + k)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 1, 4, 1, 5 };
        int k = 2;
        System.out.println("number of unique k-diff pairs in the array is: " + findPairs(nums, k));
    }
}
