package DP;

//https://leetcode.com/problems/shortest-common-supersequence/
public class ShortestCommonSuperSequence {
    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
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
        StringBuilder sb = new StringBuilder();
        while (m > 0 && n > 0) {
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                sb.append(s1.charAt(m - 1));
                m--;
                n--;
            } else if (dp[m - 1][n] > dp[m][n - 1])
                sb.append(s1.charAt(m-- - 1));
            else
                sb.append(s2.charAt(n-- - 1));
        }
        while (m > 0) sb.append(s1.charAt(m-- - 1));
        while (n > 0) sb.append(s2.charAt(n-- - 1));
        return sb.reverse().toString();
    }
}
