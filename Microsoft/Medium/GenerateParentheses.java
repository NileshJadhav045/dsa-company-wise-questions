
import java.util.*;
/* Leetcode -> 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all 
 * combinations of well-formed parentheses.
 * 
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String str = "";
        helper(n, ans, 0, 0, str);
        return ans;
    }

    public static void helper(int n, List<String> ans, int open, int close, String str) {
        if (open == n && close == n) { // base case
            ans.add(str);
            return;
        } else {
            if (open > close) { // sub-problem
                helper(n, ans, open, close + 1, str + ")");
            }
            if (open < n) { // sub-problem
                helper(n, ans, open + 1, close, str + "(");
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
