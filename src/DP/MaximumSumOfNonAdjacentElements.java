package DP;

// https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos


import java.util.ArrayList;

public class MaximumSumOfNonAdjacentElements {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        int dp[] = new int[n + 1];
        // return solveTopDown(n - 1, nums, dp);
        return solveBottomUpWithSpaceOptimization(n - 1, nums);
    }

    // Top-Down approach without memory optimization
    private static int solveTopDown(int n, ArrayList<Integer> nums, int[] dp) {
        if (n == 0) return nums.get(n);
        if (n < 0) return 0;
        if (dp[n] != 0) return dp[n];
        int first = nums.get(n) + solveTopDown(n - 2, nums, dp);
        int second = solveTopDown(n - 1, nums, dp);
        return dp[n] = Math.max(first, second);
    }

    // Bottom up approach
    private static int solveBottomUpWithoutSpaceOptimization(int n, ArrayList<Integer> nums) {
        int dp[] = new int[n + 1];
        dp[0] = nums.get(0);
        for (int i = 1; i <= n; i++) {
            int first = nums.get(i);
            if (i > 1)
                first += nums.get(i) + dp[i - 2];
            int second = dp[i - 1];
            dp[i] = Math.max(first, second);
        }
        return dp[n];
    }

    // Bottom up approach with space optimization
    private static int solveBottomUpWithSpaceOptimization(int n, ArrayList<Integer> nums) {
        int one = nums.get(0);
        int two = 0;
        for (int i = 1; i <= n; i++) {
            int first = nums.get(i);
            if (i > 1)
                first += two;
            int second = one;
            two = one;
            one = Math.max(first, second);
        }
        return one;
    }

}
