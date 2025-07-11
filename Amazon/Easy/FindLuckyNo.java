package Amazon.Easy;

/* Leetcode -> 1394. Find Lucky Integer in an Array
 * Given an array of integers arr, a lucky integer is an integer that has a 
 * frequency in the array equal to its value.

    Return the largest lucky integer in the array. 
    If there is no lucky integer return -1.

    Example 1:

    Input: arr = [2,2,3,4]
    Output: 2
    Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
 */
import java.util.HashMap;

public class FindLuckyNo {
    public static int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int freq = -1;
        for (int key : map.keySet()) {
            if (map.get(key) == key) {
                freq = key;
            }
        }
        return freq;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 4 };
        System.out.println(findLucky(arr));
    }
}
