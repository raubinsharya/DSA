package DP;

// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

public class MinimumInsertionToMakeStringPalindrome {
    public int minInsertions(String s) {
        int lcs = longestPalindromeSubseq(s);
        return s.length() - lcs;
    }

    public static int longestPalindromeSubseq(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int m = s1.length();
        int n = s2.length();
        if (s1.equals(s2)) return m;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
