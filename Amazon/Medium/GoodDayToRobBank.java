import java.util.ArrayList;
import java.util.List;
/* Leetcode -> 2100. Find Good Days to Rob the Bank
 * You and a gang of thieves are planning on robbing a bank. You are given a 
 * 0-indexed integer array security, where security[i] is the number of guards 
 * on duty on the ith day. The days are numbered starting from 0. You are also 
 * given an integer time.

    The ith day is a good day to rob the bank if:

    There are at least time days before and after the ith day,
    The number of guards at the bank for the time days before i are non-increasing, and
    The number of guards at the bank for the time days after i are non-decreasing.
    More formally, this means day i is a good day to rob the bank if and only if 
    security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].

    Return a list of all days (0-indexed) that are good days to rob the bank. 
    The order that the days are returned in does not matter.
 */
public class GoodDayToRobBank {
    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        // Arrays to store count of non-increasing days before and non-decreasing days after
        int prefix[] = new int[n]; // prefix[i] = number of consecutive days before i (including i) where security did not increase
        int suffix[] = new int[n]; // suffix[i] = number of consecutive days after i (including i) where security did not decrease
        // Fill prefix array: count days where security is non-increasing up to day i
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                count++;
            } else {
                count = 0;
            }
            prefix[i] = count;
        }
        count = 0; // Reset count for suffix

        // Fill suffix array: count days where security is non-decreasing from day i
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                count++;
            } else {
                count = 0;
            }
            suffix[i] = count;
        }

        // A day is good if it has at least 'time' days of non-increasing before
        // and at least 'time' days of non-decreasing after
        for (int i = 0; i < n; i++) {
            if (prefix[i] >= time && suffix[i] >= time) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int []security = {5,3,3,3,5,6,2}; 
        int time = 2;
        System.out.println(goodDaysToRobBank(security, time));
    }
}
