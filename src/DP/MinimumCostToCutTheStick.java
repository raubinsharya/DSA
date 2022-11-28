package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
public class MinimumCostToCutTheStick {
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int num : cuts) list.add(num);
        list.add(n);
        Collections.sort(list);
        int dp[][] = new int[cuts.length + 1][cuts.length + 1];
        for (int row[] : dp) Arrays.fill(row, -1);
        return solveTopDown(1, cuts.length - 1, list, dp);
    }

    private int solveTopDown(int i, int j, List<Integer> cuts, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int maxi = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = cuts.get(j + 1) - cuts.get(i - 1) + solveTopDown(i, k - 1, cuts, dp) + solveTopDown(k + 1, j, cuts, dp);
            maxi = Math.min(maxi, cost);
        }
        return dp[i][j] = maxi;
    }
}
