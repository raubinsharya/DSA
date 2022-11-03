package DP;

// https://leetcode.com/problems/target-sum/description/

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int dp[][] = new int[nums.length][2001];
        return solve(nums, target, 1000, nums.length - 1, dp);
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
}
