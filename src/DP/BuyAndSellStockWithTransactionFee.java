package DP;

import java.util.Arrays;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
public class BuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length + 1][2];
        for (int row[] : dp) Arrays.fill(row, -1);
        return solveTopDown(prices, 0, 1, dp, fee);
    }

    private int solveTopDown(int[] prices, int index, int buy, int[][] dp, int fee) {
        if (index == prices.length) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];
        int profit;
        if (buy == 1) {
            profit = Math.max(-prices[index] + solveTopDown(prices, index + 1, 0, dp, fee),
                    solveTopDown(prices, index + 1, 1, dp, fee));
        } else {
            profit = Math.max(prices[index] + solveTopDown(prices, index + 1, 1, dp, fee) - fee,
                    solveTopDown(prices, index + 1, 0, dp, fee));
        }
        return dp[index][buy] = profit;
    }
}
