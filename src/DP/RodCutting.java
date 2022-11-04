package DP;

// https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

public class RodCutting {

    public static int cutRod(int price[], int target) {
        int n = price.length;
        int dp[][] = new int[n][target];
        return solveTopDown(n - 1, target, price, dp);
    }

    private static int solveTopDown(int index, int n, int[] cuts, int[][] dp) {
        if (index == 0) return cuts[0] * n;
        if (dp[index][n] != 0) return dp[index][n];
        int notPick = 0 + solveTopDown(index - 1, n, cuts, dp);
        int pick = Integer.MIN_VALUE;
        int rodLen = index + 1;
        if (rodLen <= n) pick = cuts[index] + solveTopDown(index, n - rodLen, cuts, dp);
        return dp[index][n] = Math.max(pick, notPick);
    }
}
