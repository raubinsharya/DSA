package DP;

// https://leetcode.com/problems/longest-common-subsequence/description/

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m][n];
        return solveTopDown(text1, text2, m - 1, n - 1, dp);
    }

    private int solveTopDown(String text1, String text12, int m, int n, int[][] dp) {
        if (m < 0 || n < 0) return 0;
        if (dp[m][n] != 0) return dp[m][n];
        if (text1.charAt(m) == text12.charAt(n)) return 1 + solveTopDown(text1, text12, m - 1, n - 1, dp);
        return dp[m][n] = Math.max(solveTopDown(text1, text12, m - 1, n, dp), solveTopDown(text1, text12, m, n - 1, dp));
    }
}
