package DP;

import java.util.Arrays;
// https://leetcode.com/problems/distinct-subsequences/description/
public class DistinctSubsequence {
    public int numDistinct(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solveTopDown(s1, s2, m - 1, n - 1, dp);
    }

    private int solveTopDown(String s1, String s2, int i, int j, int[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int res = 0;
        if (s1.charAt(i) == s2.charAt(j))
            res += solveTopDown(s1, s2, i - 1, j - 1, dp);
        res += solveTopDown(s1, s2, i - 1, j, dp);
        return dp[i][j] = res;
    }
}
