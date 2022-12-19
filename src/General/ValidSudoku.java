package General;
// https://leetcode.com/problems/valid-sudoku/submissions/
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != '.') {
                    char temp = board[row][col]; // storing the current cell value to temp so that it will not check for the same cell in isValid function
                    board[row][col] = '.';
                    if (!isValid(board, temp, row, col)) return false;
                    board[row][col] = temp; // if current cell is valid then it will restore the cell
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, char num, int row, int col) { // this helper function checks if a number is valid for that particular cell
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num)
                return false;
        }
        return true;
    }
}
