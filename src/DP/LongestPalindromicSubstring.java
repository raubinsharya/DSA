package DP;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int m = s1.length();
        int n = s2.length();
        int maxi = 0;
        int end = 0;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (maxi <= dp[i][j]) {
                        maxi = dp[i][j];
                        end = i;
                    }
                }
            }
        }

        return s1.substring(maxi - end, end);
    }
}
