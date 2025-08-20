
public class Leetcode85 {
    /* Leetcode -> 85. Maximal Rectangle
     * Given a rows x cols binary matrix filled with 0's and 1's, 
     * find the largest rectangle containing only 1's and return its area.
     */
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length; 
        int m = matrix[0].length; 
        int dp[] = new int[m]; 
        int max = 0; 

        
        for (int i = 0; i < n; i++) {
            // Update histogram (dp) based on current row
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[j] = dp[j] + 1; // increase height if we see '1'
                } else if (matrix[i][j] == '0') {
                    dp[j] = 0; // reset height if we see '0'
                }
            }
            // After updating histogram for this row,
            // find largest rectangle in histogram
            max = Math.max(largerArea(dp), max);
        }
        return max;
    }

    
    static int largerArea(int[] heights) {
        int n = heights.length;
        int[] s_left = new int[n]; 
        int[] s_right = new int[n]; 

        // Initialize boundaries
        s_left[0] = -1; // no smaller element on the left of first bar
        s_right[n - 1] = n; // no smaller element on the right of last bar

        // Fill s_left array: nearest smaller to left for each bar
        for (int i = 1; i < n; i++) {
            int idx = i - 1;
            // keep jumping left until finding smaller element
            while (idx >= 0) {
                if (heights[idx] >= heights[i])
                    idx = s_left[idx]; // jump further left
                else
                    break;
            }
            s_left[i] = idx;
        }

        // Fill s_right array: nearest smaller to right for each bar
        for (int i = n - 1; i >= 0; i--) {
            int idx = i + 1;
            // keep jumping right until finding smaller element
            while (idx < n) {
                if (heights[idx] >= heights[i])
                    idx = s_right[idx]; // jump further right
                else
                    break;
            }
            s_right[i] = idx;
        }

        // Compute maximum rectangle area
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // width = s_right[i] - s_left[i] - 1
            int cal = heights[i] * (s_right[i] - s_left[i] - 1);
            ans = Math.max(cal, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        char matrix[][] = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
        System.out.println(maximalRectangle(matrix));
    }
}
