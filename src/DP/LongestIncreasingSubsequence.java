package DP;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/description/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length + 1][nums.length + 1];
        for (int row[] : dp) Arrays.fill(row, -1);
        return solveTopDown(nums, 0, -1, dp);
    }

    private int solveTopDown(int[] nums, int idx, int prevIdx, int[][] dp) {
        if (idx == nums.length) return 0;
        int len;
        if (dp[idx][prevIdx + 1] != -1) return dp[idx][prevIdx + 1];
        len = solveTopDown(nums, idx + 1, prevIdx, dp);
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            len = Math.max(len, 1 + solveTopDown(nums, idx + 1, idx, dp));
        }
        return dp[idx][prevIdx + 1] = len;
    }
}
