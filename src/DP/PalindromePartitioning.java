package DP;

import java.util.Arrays;
// https://leetcode.com/problems/palindrome-partitioning-ii/description/

public class PalindromePartitioning {
    public int minCut(String str) {
        int n = str.length();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solveTopDown(str, 0, n, dp) - 1;
    }

    private int solveTopDown(String str, int idx, int n, int[] dp) {
        if (idx == n) return 0;
        int min = Integer.MAX_VALUE;

        if (dp[idx] != -1) return dp[idx];

        for (int i = idx; i < n; i++) {
            if (palindrome(idx, i, str)) {
                int res = 1 + solveTopDown(str, i + 1, n, dp);
                min = Math.min(min, res);
            }
        }
        return dp[idx] = min;
    }

    private boolean palindrome(int i, int j, String str) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
