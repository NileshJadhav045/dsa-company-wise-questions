public class WordSearch {
    /* Leetcode -> 79. Word Search
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.

        The word can be constructed from letters of sequentially adjacent cells, 
        where adjacent cells are horizontally or vertically neighboring. The same 
        letter cell may not be used more than once.

     */
    public static boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;

        // Iterate over each cell in the board
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // Start DFS from each cell
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, int i, int j, String word, int index) {
        // If all characters have been matched
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and if current cell is already visited or doesn't match
        // current char
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                board[i][j] != word.charAt(index)) {
            return false;
        }

        // Temporarily mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = '.';

        // Explore all 4 directions
        boolean found = dfs(board, i + 1, j, word, index + 1) || // Down
                dfs(board, i, j + 1, word, index + 1) || // Right
                dfs(board, i - 1, j, word, index + 1) || // Up
                dfs(board, i, j - 1, word, index + 1); // Left

        // Backtrack: restore the original value
        board[i][j] = temp;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
