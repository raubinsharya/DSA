package DP;

import java.util.Arrays;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
public class BuyAndSellStockThree {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length + 1][2][3];
        for (int rows[][] : dp)
            for (int row[] : rows) Arrays.fill(row, -1);
        return solveTopDown(prices, 0, 1, dp, 2);
    }

    private int solveTopDown(int[] prices, int index, int buy, int[][][] dp, int trx) {
        if (index == prices.length || trx == 0) return 0;
        if (dp[index][buy][trx] != -1) return dp[index][buy][trx];
        int profit;
        if (buy == 1) {
            profit = Math.max(-prices[index] + solveTopDown(prices, index + 1, 0, dp, trx),
                    solveTopDown(prices, index + 1, 1, dp, trx));
        } else {
            profit = Math.max(prices[index] + solveTopDown(prices, index + 1, 1, dp, trx - 1),
                    solveTopDown(prices, index + 1, 0, dp, trx));
        }
        return dp[index][buy][trx] = profit;
    }
}
