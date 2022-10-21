package DP;

import java.util.List;

// https://leetcode.com/problems/triangle/description/

public class Triangle {
    public static int minimumPathSum(int[][] triangle, int n) {
        int dp[][] = new int[n][triangle[n - 1].length];
        return solveRec(triangle, n - 1, 0, 0, dp);
    }

    private static int solveRec(int[][] triangle, int n, int row, int col, int[][] dp) {
        if (row == n) return triangle[row][col];
        if (dp[row][col] > 0) return dp[row][col];
        int bottom = triangle[row][col] + solveRec(triangle, n, row + 1, col, dp);
        int right = triangle[row][col] + solveRec(triangle, n, row + 1, col + 1, dp);
        return dp[row][col] = Math.min(bottom, right);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][triangle.get(n - 1).size()];
        return solveRecLetCode(triangle, n - 1, 0, 0, dp);
    }

    private static int solveRecLetCode(List<List<Integer>> triangle, int n, int row, int col, int[][] dp) {
        if (row == n) return triangle.get(row).get(col);
        if (dp[row][col] > 0) return dp[row][col];
        int bottom = triangle.get(row).get(col) + solveRecLetCode(triangle, n, row + 1, col, dp);
        int right = triangle.get(row).get(col) + solveRecLetCode(triangle, n, row + 1, col + 1, dp);
        return dp[row][col] = Math.min(bottom, right);
    }

}
