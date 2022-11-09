package DP;

import java.util.Arrays;
// https://leetcode.com/problems/edit-distance/description/
public class EditDistance {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int row[] : dp) Arrays.fill(row, -1);
        return solveTopDown(s1, s2, m - 1, n - 1, dp);
    }

    private int solveTopDown(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (dp[i][j] != -1) return dp[i][j];
        int res = Integer.MAX_VALUE;
        if (s1.charAt(i) == s2.charAt(j))
            res = Math.min(res, solveTopDown(s1, s2, i - 1, j - 1, dp));
        else {
            res = Math.min(res, solveTopDown(s1, s2, i - 1, j, dp) + 1);
            res = Math.min(res, solveTopDown(s1, s2, i, j - 1, dp) + 1);
            res = Math.min(res, solveTopDown(s1, s2, i - 1, j - 1, dp) + 1);
        }
        return dp[i][j] = res;
    }
}
