package DP;

import java.util.Arrays;
// https://leetcode.com/problems/is-subsequence/description/
public class IsSubSequence {
    public static boolean isSubsequence(String str, String original) {
        if (str.isEmpty()) return true;
        if (original == null) return false;
        int dp[][] = new int[original.length()][str.length()];
        for (int row[] : dp) Arrays.fill(row, -1);
        int res = solveTopDown(original, str, original.length() - 1, str.length() - 1, dp);
        return res == 1;
    }

    private static int solveTopDown(String original, String str, int i, int j, int[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (original.charAt(i) == str.charAt(j)) {
            return dp[i][j] = solveTopDown(original, str, i - 1, j - 1, dp); // pick case
        }
        return dp[i][j] = solveTopDown(original, str, i - 1, j, dp); // not pick case
    }
}
