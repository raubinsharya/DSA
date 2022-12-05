package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://leetcode.com/problems/n-queens/description/
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        List<List<String>> result = new ArrayList<>();
        for (char row[] : board) Arrays.fill(row, '.');
        solve(result, board, 0, n);
        return result;
    }

    private void solve(List<List<String>> result, char[][] board, int col, int n) {
        if (col == n) {
            List<String> ds = new ArrayList<>();
            for (char row[] : board)
                ds.add(new String(row));
            result.add(ds);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 'Q';
                solve(result, board, col + 1, n);
                board[i][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int rows, int cols, int n) {
        int row = rows;
        int col = cols;
        while (row >= 0 && col >= 0)
            if (board[row--][col--] == 'Q') return false;
        col = cols;
        while (col >= 0) if (board[rows][col--] == 'Q') return false;
        col = cols;
        row = rows;
        while (row < n && col >= 0)
            if (board[row++][col--] == 'Q') return false;
        return true;
    }
}
