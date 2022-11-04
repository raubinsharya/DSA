package DP;

// https://leetcode.com/problems/target-sum/description/

import java.util.Arrays;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(target, nums);
    }

    private int solve(int[] nums, int target, int sum, int index, int dp[][]) {
        if (index == -1) {
            if (sum - 1000 == target) return 1;
            return 0;
        }
        if (dp[index][sum] != -1) return dp[index][sum];
        int plus = solve(nums, target, sum + nums[index], index - 1, dp);
        int minus = solve(nums, target, sum - nums[index], index - 1, dp);
        return dp[index][sum] = plus + minus;
    }

    public int countPartitions(int d, int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum - d < 0) return 0;
        if ((sum - d) % 2 != 0) return 0;
        int target = (sum - d) / 2;
        return findWays(arr, target);
    }

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
        return dp[index][target] = (pick + notPick);
    }
}
