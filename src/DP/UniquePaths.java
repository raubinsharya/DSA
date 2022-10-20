package DP;

// https://leetcode.com/problems/unique-paths/description/

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        return solveTopDown(m - 1, n - 1, dp);
    }

    private int solveTopDown(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;
        if (dp[m][n] > 0) return dp[m][n];
        int top = solveTopDown(m - 1, n, dp);
        int left = solveTopDown(m, n - 1, dp);
        return dp[m][n] = top + left;
    }

    private int solveBottomUp(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                } else {
                    int top = 0, left = 0;
                    if (i > 0) top = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = top + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
