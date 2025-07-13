
import java.util.*;
/* Leetcode -> 599. Minimum Index Sum of Two Lists
 * Given two arrays of strings list1 and list2, find the common strings with the 
 * least index sum.

    A common string is a string that appeared in both list1 and list2.

    A common string with the least index sum is a common string such that if 
    it appeared at list1[i] and list2[j] then i + j should be the minimum value 
    among all the other common strings.

    Return all the common strings with the least index sum. 
    Return the answer in any order.
 */

public class MinIdxSum {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList<>(); // To store the result restaurants
        Map<String, Integer> map = new HashMap<>(); // To store list1 restaurant names and their indices
        int minSum = Integer.MAX_VALUE; // To track the minimum index sum

        // Step 1: Store each restaurant from list1 with its index in the map
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        // Step 2: Loop through list2 to find common restaurants
        for (int i = 0; i < list2.length; i++) {
            // If restaurant exists in list1
            if (map.containsKey(list2[i])) {
                int sum = map.get(list2[i]) + i; // Calculate index sum

                if (sum < minSum) {
                    ans.clear(); // Found a smaller index sum, clear old results
                    ans.add(list2[i]); // Add current restaurant
                    minSum = sum; // Update minimum index sum
                } else if (sum == minSum) {
                    ans.add(list2[i]); // Same index sum, add to result
                }
            }
        }

        // Convert the result list to an array and return
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String list1[] = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String list2[] = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };

        // Call the method and print the result
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
        // Output: [Shogun]
    }
}
