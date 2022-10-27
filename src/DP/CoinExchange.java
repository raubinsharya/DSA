package DP;

// https://www.codingninjas.com/codestudio/problems/minimum-elements_3843091?leftPanelTab=0
// https://leetcode.com/problems/coin-change/description/
import java.util.Arrays;

public class CoinExchange {
    public static int coinChange(int num[], int target) {
        int n = num.length;
        int dp[][] = new int[n + 1][target + 1];
        for (int row[] : dp) Arrays.fill(row, -1);
        int res = solveTopDown(num, target, n - 1, dp);
        return res >= Integer.MAX_VALUE / 2 ? -1 : res;
    }

    private static int solveTopDown(int[] arr, int target, int index, int dp[][]) {
        if (index == 0) {
            if (target % arr[0] == 0) return target / arr[0];
            return Integer.MAX_VALUE / 2;
        }
        int notTake = solveTopDown(arr, target, index - 1, dp);
        if (dp[index][target] != -1) return dp[index][target];
        int take = Integer.MAX_VALUE / 2;
        if (arr[index] <= target)
            take = 1 + solveTopDown(arr, target - arr[index], index, dp);
        return dp[index][target] = Math.min(take, notTake);
    }
}
