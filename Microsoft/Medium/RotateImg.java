public class RotateImg {
    public static void rotate(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;

        // Step 1: Transpose the matrix
        // Transpose means converting rows to columns (i.e., matrix[i][j] =
        // matrix[j][i])
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        // This effectively rotates the matrix 90 degrees clockwise
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int temp = matrix[i][col - 1 - j];
                matrix[i][col - 1 - j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static void print(int matrix[][]){
        int row = matrix.length, col = matrix[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("Original Matrix: ");
        print(matrix);
        System.out.println("After Rotating Matrix: ");
        rotate(matrix);
        print(matrix);
    }
}
