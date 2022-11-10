package DP;

import java.util.Arrays;

// https://leetcode.com/problems/wildcard-matching/description/

public class WildCardMatching {
    public boolean isMatch(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int row[] : dp) Arrays.fill(row, -1);
        return solveTopDown(s1, s2, m - 1, n - 1, dp) == 0 ? false : true;
    }

    private int solveTopDown(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) return 1;
        if (j < 0 && i >= 0) return 0;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++)
                if (s2.charAt(k) != '*') return 0;
            return 1;
        }
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?') {
            return dp[i][j] = solveTopDown(s1, s2, i - 1, j - 1, dp);
        }
        if (s2.charAt(j) == '*') {
            return dp[i][j] = solveTopDown(s1, s2, i - 1, j, dp) |
                    solveTopDown(s1, s2, i, j - 1, dp);
        }
        return dp[i][j] = 0;
    }
}
