package DP;

import java.util.Arrays;

// https://www.codingninjas.com/codestudio/problems/0-1-knapsack_920542?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

public class ZeroOneKnapsack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][] = new int[n + 1][maxWeight + 1];
        for (int row[] : dp) Arrays.fill(row, -1);
        return solveTopDown(weight, value, n - 1, maxWeight, dp);
    }

    private static int solveTopDown(int[] weight, int[] value, int index, int maxWeight, int[][] dp) {
        if (index == 0) {
            if (weight[0] <= maxWeight) return value[0];
            return 0;
        }
        if (dp[index][maxWeight] != -1) return dp[index][maxWeight];
        int notTake = solveTopDown(weight, value, index - 1, maxWeight, dp);
        int take = Integer.MIN_VALUE;
        if (weight[index] <= maxWeight)
            take = value[index] + solveTopDown(weight, value, index - 1, maxWeight - weight[index], dp);
        return dp[index][maxWeight] = Math.max(take, notTake);
    }
}
