package DP;

import java.util.Arrays;
// https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(solveTopDown(cost, 0, dp), solveTopDown(cost, 1, dp));
    }

    private int solveTopDown(int[] costs, int idx, int[] dp) {
        if (idx >= costs.length) return 0;
        if (dp[idx] != -1) return dp[idx];
        int cost = Integer.MAX_VALUE;
        cost = Math.min(cost, costs[idx] + solveTopDown(costs, idx + 1, dp));
        cost = Math.min(cost, costs[idx] + solveTopDown(costs, idx + 2, dp));
        return dp[idx] = cost;
    }
}
