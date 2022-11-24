package DP;

import java.util.Arrays;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
public class BuyAndSellStockFour {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][k + 1];
        for (int rows[][] : dp)
            for (int row[] : rows) Arrays.fill(row, -1);
        return solveTopDown(prices, dp, 0, 1, k, n);
    }

    private int solveTopDown(int[] prices, int[][][] dp, int idx, int buy, int trx, int n) {
        if (idx == n || trx == 0) return 0;
        if (dp[idx][buy][trx] != -1) return dp[idx][buy][trx];
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[idx] + solveTopDown(prices, dp, idx + 1, 0, trx, n),
                    solveTopDown(prices, dp, idx + 1, 1, trx, n));
        } else {
            profit = Math.max(
                    prices[idx] + solveTopDown(prices, dp, idx + 1, 1, trx - 1, n),
                    solveTopDown(prices, dp, idx + 1, 0, trx, n)
            );
        }
        return dp[idx][buy][trx] = profit;
    }
}
