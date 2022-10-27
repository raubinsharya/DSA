package DP;

import java.util.Arrays;

// https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

public class CountNumberOfSubsetEqualsK {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int dp[][] = new int[n + 1][tar + 1];
        for (int arr[] : dp) Arrays.fill(arr, -1);
        return solve(num, tar, n - 1, dp);
    }

    private static int solve(int[] arr, int target, int index, int dp[][]) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2; // base case for input like (0 0 4)
            if (target == arr[0] || target == 0) return 1;
            return 0;
        }
        if (dp[index][target] != -1) return dp[index][target];
        int pick = 0;
        if (arr[index] <= target) pick = solve(arr, target - arr[index], index - 1, dp);
        int notPick = solve(arr, target, index - 1, dp);
        return dp[index][target] = pick + notPick;
    }
}
