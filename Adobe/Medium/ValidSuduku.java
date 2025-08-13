import java.util.HashSet;

public class ValidSuduku {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSet = new HashSet[9]; // Tracks numbers in each row
        HashSet<Character>[] colSet = new HashSet[9]; // Tracks numbers in each column
        HashSet<Character>[] boxSet = new HashSet[9]; // Tracks numbers in each 3x3 sub-box

        // Initialize all 9 sets for rows, columns, and boxes
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        // Loop over each cell of the 9x9 Sudoku board
        for (int i = 0; i < 9; i++) { // i → row index
            for (int j = 0; j < 9; j++) { // j → column index
                char ch = board[i][j];

                // Calculate the index of the corresponding 3x3 sub-box
                // Box indexing:
                // Row group = i / 3 (0,1,2)
                // Column group = j / 3 (0,1,2)
                // Overall box index = rowGroup * 3 + colGroup
                int box = (i / 3) * 3 + (j / 3);

                // Skip empty cells
                if (ch == '.') {
                    continue;
                }

                // If number already exists in the same row, column, or box → invalid Sudoku
                if (rowSet[i].contains(ch) ||
                        colSet[j].contains(ch) ||
                        boxSet[box].contains(ch)) {
                    return false;
                }

                // Otherwise, record the number in row, column, and box sets
                rowSet[i].add(ch); // Mark number as seen in this row
                colSet[j].add(ch); // Mark number as seen in this column
                boxSet[box].add(ch); // Mark number as seen in this 3x3 sub-box
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        System.out.println(isValidSudoku(board));
    }
}
