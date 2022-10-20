package DP;

// https://leetcode.com/problems/unique-paths-ii/description/

public class UniquePathTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        return solveBottomUp(m, n, obstacleGrid);
    }

    private int solveTopDown(int m, int n, int[][] obstacleGrid, int[][] dp) {
        if (m < 0 || n < 0 || obstacleGrid[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (dp[m][n] > 0) return dp[m][n];
        int top = solveTopDown(m - 1, n, obstacleGrid, dp);
        int left = solveTopDown(m, n - 1, obstacleGrid, dp);
        return dp[m][n] = top + left;
    }
    private int solveBottomUp(int m, int n, int obstacleGrid[][]) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0 && obstacleGrid[i][j] != 1) {
                    dp[0][0] = 1;
                } else if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
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
