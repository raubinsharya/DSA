package DP;

import java.util.Arrays;

// https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1

public class ChocolatePickup {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int dp[][][] = new int[r][c][c];
        for (int row[][] : dp)
            for (int ro[] : row) Arrays.fill(ro, -1);
        return solveTopDown(0, 0, c - 1, r - 1, c, grid, dp);
    }

    private static int solveTopDown(int row, int col1, int col2, int r, int c, int[][] grid, int dp[][][]) {
        if (col1 < 0 || col2 < 0 || col1 >= c || col2 >= c) return Integer.MIN_VALUE;
        if (row == r) {
            if (col1 == col2) return grid[row][col1];
            else return grid[row][col1] + grid[row][col2];
        }
        if (dp[row][col1][col2] != -1) return dp[row][col1][col2];
        int max = Integer.MIN_VALUE;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int sum = 0;
                if (col1 == col2) sum += grid[row][col1];
                else sum += grid[row][col1] + grid[row][col2];
                sum += solveTopDown(row + 1, col1 + i, col2 + j, r, c, grid, dp);
                max = Math.max(sum, max);
            }
        }
        return dp[row][col1][col2] = max;
    }
}
