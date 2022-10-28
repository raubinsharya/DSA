package DP;

import java.util.Arrays;
//https://www.codingninjas.com/codestudio/problems/unbounded-knapsack_1215029?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
public class UnboundedKnapsack {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int dp[][] = new int[n + 1][w + 1];
        for (int row[] : dp) Arrays.fill(row, -1);
        return solveTopDown(weight, profit, n - 1, w, dp);
    }

    private static int solveTopDown(int[] weight, int[] value, int index, int maxWeight, int[][] dp) {
        if (index == 0)
            return (maxWeight / weight[0]) * value[0];
        if (dp[index][maxWeight] != -1) return dp[index][maxWeight];
        int notTake = solveTopDown(weight, value, index - 1, maxWeight, dp);
        int take = Integer.MIN_VALUE;
        if (weight[index] <= maxWeight)
            take = value[index] + solveTopDown(weight, value, index, maxWeight - weight[index], dp);
        return dp[index][maxWeight] = Math.max(take, notTake);
    }
}
