public class SumOfSqur {
    /*
     * Leetcode -> 633. Sum of Square Numbers
     * Given a non-negative integer c, decide whether there're two integers
     * a and b such that a2 + b2 = c.
     * Example 1:
        Input: c = 5
        Output: true
        Explanation: 1 * 1 + 2 * 2 = 5
     */
    public static boolean judgeSquareSum(int c) {
        // If the number is negative, it can't be a sum of two squares
        if (c < 0)
            return false;

        long left = 0;
        long right = (long) Math.sqrt(c); // Start from sqrt(c) to avoid unnecessary iterations

        // Use two-pointer approach to find two numbers whose squares sum up to c
        while (left <= right) {
            long sum = left * left + right * right;

            if (sum == c) {
                // Found a pair (left, right) such that left² + right² == c
                return true;
            } else if (sum < c) {
                // If sum is too small, move the left pointer up to increase the sum
                left++;
            } else {
                // If sum is too big, move the right pointer down to decrease the sum
                right--;
            }
        }

        // If no such pair is found, return false
        return false;
    }

    public static void main(String[] args) {
        int c = 5;
        System.out.println(judgeSquareSum(c));
    }
}
