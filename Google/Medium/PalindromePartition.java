import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    static List<List<String>> ans;

    public static List<List<String>> partition(String s) {
        int n = s.length();
        ans = new ArrayList<>();
        int dp[][] = new int[n + 1][n + 1];
        recur(new ArrayList<>(), 0, s, dp);
        return ans;
    }

    public static void recur(List<String> curr, int i, String s, int[][] dp) {
        if (s.length() == i) {
            ans.add(curr);
            return;
        }
        if (i > s.length())
            return;
        for (int j = i; j < s.length(); j++) {
            String temp = s.substring(i, j + 1);
            if (dp[i][j] == 1 || isPalindrome(temp, dp)) {
                dp[i][j] = 1;
                List<String> copy = new ArrayList<>(curr);
                copy.add(temp);
                recur(copy, j + 1, s, dp);
            }
        }
    }

    public static boolean isPalindrome(String s, int[][] dp) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}
