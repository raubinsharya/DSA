package DP;

import java.util.Arrays;

// Problem Link
// https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1

public class ClimbingStairs {
    public static int countDistinctWayToClimbStair(long nStairs) {
        int n = (int) nStairs;
        int dp[] = new int[n + 1];
        return dp(n, dp);
    }

    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        dp(n, dp);
        return dp[n];
    }

    private static int dp(int step, int[] dp) {
        if (step <= 1) return 1;
        if (dp[step] == 0) {
            int one = dp(step - 1, dp);
            int two = dp(step - 2, dp);
            dp[step] = (one + two) % 1000000007;
        }
        return dp[step];
    }
}
