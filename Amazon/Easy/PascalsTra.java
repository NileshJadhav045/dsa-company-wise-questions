package Amazon.Easy;

public class PascalsTra {
    public static void generate(int numRows) {
        int ans[][] = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0 || i == j) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = ans[i - 1][j - 1] + ans[i - 1][j];
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n = 5;
        generate(n);

    }
}
