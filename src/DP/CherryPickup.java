package DP;

import java.util.Arrays;

// https://leetcode.com/problems/cherry-pickup/description/
public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int dp[][][][] = new int[row][col][row][col];
        for (int rrrr[][][] : dp)
            for (int rrr[][] : rrrr)
                for (int r[] : rrr) Arrays.fill(r, -1);
        int res = solveTopDown(0, 0, 0, 0, row, col, grid, dp);
        return res < 0 ? 0 : res;
    }

    private int solveTopDown(int row1, int col1, int row2, int col2, int r, int c, int[][] grid, int dp[][][][]) {
        if (row1 >= r || row2 >= r || col1 >= c || col2 >= c || grid[row1][col1] == -1 || grid[row2][col2] == -1)
            return Integer.MIN_VALUE;
        if (row1 == r - 1 && col1 == c - 1)
            return grid[row1][col1];
        if (dp[row1][col1][row2][col2] != -1) return dp[row1][col1][row2][col2];
        int sum = 0;
        if (row1 == row2 && col1 == col2) sum += grid[row1][col1];
        else sum += grid[row1][col1] + grid[row2][col2];

        int one = solveTopDown(row1, col1 + 1, row2, col2 + 1, r, c, grid, dp);   // h h
        int three = solveTopDown(row1 + 1, col1, row2, col2 + 1, r, c, grid, dp);  // v h
        int two = solveTopDown(row1 + 1, col1, row2 + 1, col2, r, c, grid, dp);  // v v
        int four = solveTopDown(row1, col1 + 1, row2 + 1, col2, r, c, grid, dp);  // h v
        sum += Math.max(Math.max(one, two), Math.max(three, four));
        return dp[row1][col1][row2][col2] = sum;
    }
}
