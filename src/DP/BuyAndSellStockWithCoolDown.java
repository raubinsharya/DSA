package DP;

import java.util.Arrays;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
public class BuyAndSellStockWithCoolDown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];
        for (int row[] : dp) Arrays.fill(row, -1);
        return solveTopDown(prices, dp, 0, 1, n);
    }

    private int solveTopDown(int[] prices, int[][] dp, int idx, int buy, int n) {
        if (idx >= n) return 0;
        if (dp[idx][buy] != -1) return dp[idx][buy];
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[idx] + solveTopDown(prices, dp, idx + 1, 0, n),
                    solveTopDown(prices, dp, idx + 1, 1, n));
        } else {
            profit = Math.max(prices[idx] + solveTopDown(prices, dp, idx + 2, 1, n),
                    solveTopDown(prices, dp, idx + 1, 0, n));
        }
        return dp[idx][buy] = profit;
    }
}
