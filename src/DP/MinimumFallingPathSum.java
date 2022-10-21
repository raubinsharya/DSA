package DP;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-falling-path-sum/description/

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row][col];
        for (int[] rows : dp) Arrays.fill(rows, -1);
        int min = 500000;
        for (int i = 0; i < col; i++) {
            min = Math.min(min, solve(matrix, row - 1, i, dp));
        }
        return min;
    }

    private int solve(int[][] matrix, int row, int col, int[][] dp) {
        if (col < 0 || col >= matrix[0].length) return 500000;
        if (row == 0) return matrix[row][col];
        if (dp[row][col] != -1) return dp[row][col];
        int top = matrix[row][col] + solve(matrix, row - 1, col, dp);
        int left = matrix[row][col] + solve(matrix, row - 1, col - 1, dp);
        int right = matrix[row][col] + solve(matrix, row - 1, col + 1, dp);
        return dp[row][col] = Math.min(top, Math.min(left, right));
    }
}
