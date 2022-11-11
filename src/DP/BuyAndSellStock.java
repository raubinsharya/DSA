package DP;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxi = 0;
        for (int i = 1; i < prices.length; i++) {
            maxi = Math.max(maxi, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxi;
    }
}
