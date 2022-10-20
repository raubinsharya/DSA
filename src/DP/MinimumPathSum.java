package DP;
// https://leetcode.com/problems/minimum-path-sum/description/

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // int dp[][] = new int[row][col];
        return solveBottomUp(row, col, grid);
    }

    private int solveTopDown(int row, int col, int[][] grid, int[][] dp) {
        if (row < 0 || col < 0) return Integer.MAX_VALUE / 2;
        if (row == 0 && col == 0) return grid[row][col];
        if (dp[row][col] > 0) return dp[row][col];
        int top = solveTopDown(row - 1, col, grid, dp) + grid[row][col];
        int left = solveTopDown(row, col - 1, grid, dp) + grid[row][col];
        return dp[row][col] = Math.min(top, left);
    }

    private int solveBottomUp(int row, int col, int[][] grid) {
        int dp[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int top = grid[i][j];
                    if (i > 0) top += dp[i - 1][j];
                    else top += Integer.MAX_VALUE / 2;
                    int left = grid[i][j];
                    if (j > 0) left += dp[i][j - 1];
                    else left += Integer.MAX_VALUE / 2;
                    dp[i][j] = Math.min(top, left);
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
