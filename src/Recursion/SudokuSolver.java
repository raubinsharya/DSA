package Recursion;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, num, row, col)) {
                            board[row][col] = num;
                            if (solve(board)) return true;
                            else board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }

        }
        return true; // if every cell gets filled then that sudoku is possible hence return true
    }

    private boolean isValid(char[][] board, char num, int row, int col) { // this helper function checks if a number is valid for that particular cell
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num)
                return false;
        }
        return true;
    }
}
