package DP;

// https://www.codingninjas.com/codestudio/problems/longest-common-substring_1235207?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

public class LongestCommonSubstring {
    public static int lcs(String str1, String str2) {
        int maxi = 0;
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxi = Math.max(maxi, dp[i][j]);
                } else dp[i][j] = 0;
            }
        }
        return maxi;
    }
}
