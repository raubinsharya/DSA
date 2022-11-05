package DP;

public class LCSPrint {
    public static String longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m][n];
        StringBuilder sb = new StringBuilder();
        int lcsLen = solveTopDown(text1, text2, m - 1, n - 1, dp, sb);
        return sb.append(" " + lcsLen).reverse().toString();
    }

    private static int solveTopDown(String text1, String text12, int m, int n, int[][] dp, StringBuilder sb) {
        if (m < 0 || n < 0) return 0;
        if (dp[m][n] != 0) return dp[m][n];
        if (text1.charAt(m) == text12.charAt(n)) {
            sb.append(text1.charAt(m));
            return 1 + solveTopDown(text1, text12, m - 1, n - 1, dp, sb);
        }
        return dp[m][n] = Math.max(solveTopDown(text1, text12, m - 1, n, dp, sb), solveTopDown(text1, text12, m, n - 1, dp, sb));
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcdef", "def"));
    }
}
