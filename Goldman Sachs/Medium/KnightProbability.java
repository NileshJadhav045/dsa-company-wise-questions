
public class KnightProbability {
    /* Leetcode -> 688. Knight Probability in Chessboard
     * On an n x n chessboard, a knight starts at the cell (row, column) and
     * attempts to make exactly k moves. The rows and columns are 0-indexed, so the
     * top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).
     * 
     * A chess knight has eight possible moves it can make, as illustrated below.
     * Each move is two cells in a cardinal direction, then one cell in an
     * orthogonal direction.
     * Each time the knight is to move, it chooses one of eight possible moves
     * uniformly at random (even if the piece would go off the chessboard) and moves
     * there.
     * 
     * The knight continues moving until it has made exactly k moves or has moved
     * off the chessboard.
     * 
     * Return the probability that the knight remains on the board after it has
     * stopped moving.
     */
    public static double knightProbability(int n, int k, int row, int column) {
        // All 8 possible knight moves on a chessboard
        int directions[][] = {
                { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 },
                { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }
        };

        // 3D DP array: dp[moves][i][j] stores the probability of the knight
        // being on cell (i, j) after 'moves' moves
        double dp[][][] = new double[k + 1][n][n];

        // Base case: at move 0, the knight is at the starting position with probability
        // 1
        dp[0][row][column] = 1.0;

        // Loop through each number of moves from 1 to k
        for (int moves = 1; moves <= k; moves++) {
            // Iterate over each cell on the board
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Check all 8 directions the knight could have come from
                    for (int[] direction : directions) {
                        int prevI = i - direction[0];
                        int prevJ = j - direction[1];

                        // If the previous cell is within board boundaries
                        if (prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n) {
                            // Add the probability of reaching current cell (i, j)
                            // from the previous cell with one knight move
                            dp[moves][i][j] += dp[moves - 1][prevI][prevJ] / 8.0;
                        }
                    }
                }
            }
        }

        // Sum up the probabilities of the knight being on any cell on the board after k
        // moves
        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += dp[k][i][j];
            }
        }

        // Return the total probability of the knight staying on the board after k moves
        return ans;
    }

    public static void main(String[] args) {
        int n = 3, k = 2, row = 0, column = 0;
        System.out.println(knightProbability(n, k, row, column));
    }
}
