package Atlassian.Easy;

import java.util.*;
/* Leetcode -> 137. Single Number II
 * Given an integer array nums where every element appears three times 
 * except for one, which appears exactly once. Find the single element 
 * and return it.

    You must implement a solution with a linear runtime complexity and use 
    only constant extra space.
 * 
 */
public class SingleNumber {
    public static int singleNumber1(int[] nums) {
        // Create a HashMap to store frequency of each number
        Map<Integer, Integer> map = new HashMap<>();

        // Count occurrences of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find and return the number that appears only once
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey(); // Found the single number
            }
        }

        // If no such number is found, return -1 (shouldn't happen for valid input)
        return -1;
    }

    public static int singleNumber(int[] nums) {
        int once = 0, twos = 0;

        for (int i = 0; i < nums.length; i++) {
            // 'once' holds bits that have appeared only once
            // 'twos' holds bits that have appeared twice

            // First update 'once', removing bits that are already in 'twos'
            once = (once ^ nums[i]) & ~twos;

            // Then update 'twos', removing bits that are now in 'once'
            twos = (twos ^ nums[i]) & ~once;
        }

        // 'once' will contain the number that appears exactly once
        return once;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 2 };
        System.out.println(singleNumber(nums));
    }
}
