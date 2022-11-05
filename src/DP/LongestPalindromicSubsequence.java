package DP;
// https://leetcode.com/problems/longest-palindromic-subsequence/description/
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j < n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m][n];
    }
}
