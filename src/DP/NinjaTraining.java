package DP;

import java.util.Arrays;

// https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][4];
        for (int row[] : dp) Arrays.fill(row, -1);
        return solveTopDown(n - 1, 3, points, dp);
    }

    private static int solveTopDown(int day, int last, int[][] points, int[][] dp) {
        int maxi = 0;
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++)
                if (i != last) max = Math.max(max, points[0][i]);
            return dp[day][last] = max;
        }
        if (dp[day][last] != -1) return dp[day][last];
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = solveTopDown(day - 1, i, points, dp) + points[day][i];
                maxi = Math.max(maxi, point);
            }
        }
        return dp[day][last] = maxi;
    }

    private static int solveBottomUp(int n, int[][] points) {
        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for (int day = 1; day < n; day++)
            for (int last = 0; last < 4; last++)
                for (int task = 0; task < 3; task++)
                    if (task != last)
                        dp[day][last] = Math.max(points[day][task] + dp[day - 1][task], dp[day][last]);

        return dp[n - 1][3];
    }
}
