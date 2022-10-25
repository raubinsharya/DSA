package DP;

import java.util.Arrays;

// https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=1

public class SubsetSumEqualsK {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        int dp[][] = new int[n + 1][k + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        int res = solveTopDown(arr, k, n - 1, dp);
        return res == 1;
    }

    private static int solveTopDown(int[] arr, int target, int n, int dp[][]) {
        if (target == 0) return 1;
        if (n == 0) {
            if (arr[0] == target) return 1;
            else return 0;
        }
        if (dp[n][target] != -1)
            return dp[n][target];
        int pick = 0;
        if (target >= arr[n]) pick = solveTopDown(arr, target - arr[n], n - 1, dp);
        int notPick = solveTopDown(arr, target, n - 1, dp);
        return dp[n][target] = notPick | pick;
    }
}
