public class CountNoTeam {
    /* Leetcode ->1395. Count Number of Teams
     * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

        You have to form a team of 3 soldiers amongst them under the following rules:

        Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
        A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
        Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
     */
    public static  int numTeams(int[] rating) {
    // ls = left smaller, lg = left greater
    // rs = right smaller, rg = right greater
    int ls, lg, rs, rg;
    int n = rating.length;
    int ans = 0;

    // Iterate through each soldier as the middle soldier in a team of 3
    for (int i = 0; i < n; i++) {
        ls = 0;
        lg = 0;
        rs = 0;
        rg = 0;

        // Compare with every other soldier
        for (int j = 0; j < n; j++) {
            if (j < i) {
                // Count soldiers to the left of i
                if (rating[j] < rating[i])
                    ls++; // Smaller rating on the left
                else if (rating[j] > rating[i])
                    lg++; // Greater rating on the left
            } else if (j > i) {
                // Count soldiers to the right of i
                if (rating[j] < rating[i])
                    rs++; // Smaller rating on the right
                else if (rating[j] > rating[i])
                    rg++; // Greater rating on the right
            }
        }

        // Valid increasing teams: left smaller * right greater
        // Valid decreasing teams: left greater * right smaller
        ans += ls * rg + rs * lg;
    }

    return ans; // Total number of valid teams
}

    public static void main(String[] args) {
        int[]rating = {2,5,3,4,1};
        System.out.println(numTeams(rating));
    }
}
