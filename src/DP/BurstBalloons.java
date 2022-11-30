package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://leetcode.com/problems/burst-balloons/description/
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int dp[][] = new int[nums.length + 1][nums.length + 1];
        for (int row[] : dp) Arrays.fill(row, -1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int num : nums) list.add(num);
        list.add(1);
        return solveTopDown(list, 1, nums.length, dp);
    }

    private int solveTopDown(List<Integer> list, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = list.get(i - 1) * list.get(k) * list.get(j + 1) +
                    solveTopDown(list, i, k - 1, dp) +
                    solveTopDown(list, k + 1, j, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }

    private int solveBottomUp(List<Integer> list, int n) {
        int dp[][] = new int[n + 1][n + 1];
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int maxi = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = list.get(i - 1) * list.get(k) * list.get(j + 1) +
                            dp[i][k - 1] +
                            dp[k + 1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }

}
