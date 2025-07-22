public class DiagonalSum {
    public static int diagonalSum1(int[][] mat) { // Brute Force - O(n^2)
        int sum = 0;
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j || i + j == n - 1) {
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }

    public static int diagonalSum(int[][] mat) { // Optimal - O(n)
        int sum = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i]; // primary diagonal
            if (i != n - 1 - i) {
                sum += mat[i][n - 1 - i]; // secondary diagonal
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println(diagonalSum(mat));
        System.out.println(diagonalSum1(mat));
    }
}
