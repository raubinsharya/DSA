package DP;

import java.util.Arrays;
// https://leetcode.com/problems/coin-change-ii/description/
public class CoinExchangeTwo {
    public static int change(int target, int num[]) {
        int n = num.length;
        int dp[][] = new int[n + 1][target + 1];
        for (int row[] : dp) Arrays.fill(row, -1);
        int res = solveTopDown(num, target, n - 1, dp);
        return res;
    }

    private static int solveTopDown(int[] arr, int target, int index, int dp[][]) {
        if (index == 0) {
            if (target % arr[0] == 0) return 1;
            return 0;
        }
        int notTake = solveTopDown(arr, target, index - 1, dp);
        if (dp[index][target] != -1) return dp[index][target];
        int take = 0;
        if (arr[index] <= target)
            take = solveTopDown(arr, target - arr[index], index, dp);
        return dp[index][target] = take + notTake;
    }
}
