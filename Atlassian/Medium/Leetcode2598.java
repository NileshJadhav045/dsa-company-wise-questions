public class Leetcode2598 {
    public static int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        // frequency array to track how many times each remainder appears
        int v[] = new int[n];

        // Normalize each number with modulo and count occurrences
        for (int i = 0; i < n; i++) {
            // normalize nums[i] in range [0, value-1]
            int val = (nums[i] % value + value) % value;
            // only track if remainder is < n (beyond that doesn't matter for mex <= n)
            if (val < n) {
                v[val]++;
            }
        }

        // Default answer is n (if all [0..n-1] are filled, then mex = n)
        int ans = n;

        // Try to find the smallest index (mex) not covered
        for (int i = 0; i < n; i++) {
            if (v[i] == 0) {
                // If no number maps to this remainder -> this index is missing
                ans = i;
                break;
            } else {
                // Use one occurrence of this remainder
                v[i]--;
                // If still occurrences left, "shift" them to the next valid position
                // i.e., remainder i can also cover i+value, i+2*value, etc.
                if (v[i] >= 1 && i + value < n) {
                    v[i + value] += v[i];
                    v[i] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, -10, 7, 13, 6, 8 };
        int value = 5;
        System.out.println(findSmallestInteger(nums, value));
    }

}
