
public class Leetcode829 {
    public static int consecutiveNumbersSum(int n) {
        // Max possible length of sequence (k) can be derived from quadratic formula
        // Since 1 + 2 + ... + k = k*(k+1)/2 ≤ n
        // So k ≈ sqrt(2n + 0.25) - 0.5
        double k = Math.sqrt(2 * n + 0.25) - 0.5;

        int count = 0;

        // Try all possible lengths of sequence from 1 to k
        for (int i = 1; i <= k; i++) {
            // Formula: n = x + (x+1) + ... + (x+i-1)
            // => n = i*x + i*(i-1)/2
            // => (n - i*(i+1)/2) must be divisible by i to get integer starting x
            if ((n - i * (i + 1) / 2) % i == 0.0) {
                count++; // valid sequence found
            }
        }

        // Return total number of ways to represent n
        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(consecutiveNumbersSum(n));
    }
}
