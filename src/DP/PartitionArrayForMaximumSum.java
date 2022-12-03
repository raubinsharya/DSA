package DP;

import java.util.Arrays;

// https://leetcode.com/problems/partition-array-for-maximum-sum/description/

public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solveTopDown(arr, 0, n, k, dp);
    }

    private int solveTopDown(int[] arr, int idx, int n, int k, int[] dp) {
        if (idx == n) return 0;
        int len = 0;
        if (dp[idx] != -1) return dp[idx];
        int maxi = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i = idx; i < Math.min(idx + k, n); i++) {
            len++;
            maxi = Math.max(maxi, arr[i]);
            int sum = maxi * len + solveTopDown(arr, i + 1, n, k, dp);
            ans = Math.max(ans, sum);
        }
        return dp[idx] = ans;
    }
}
