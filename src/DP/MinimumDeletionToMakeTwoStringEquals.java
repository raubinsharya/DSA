package DP;

//https://leetcode.com/problems/delete-operation-for-two-strings/

public class MinimumDeletionToMakeTwoStringEquals {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int lcs = lcs(word2, word1);
        return (m - lcs) + (n - lcs);
    }

    private int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (s1.equals(s2)) return m;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
