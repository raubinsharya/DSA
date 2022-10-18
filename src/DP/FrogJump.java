package DP;

// Problem Link
// https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1


public class FrogJump {
    public static int frogJump(int n, int heights[]) {
        int dp[] = new int[n + 1];
        return solve(n, dp, heights);
    }

    public static int solve(int n, int[] dp, int[] heights) {
        if (n == 0) return 0;
        if (dp[n] != 0) return dp[n];
        int one = solve(n - 1, dp, heights) + Math.abs(heights[n] - heights[n - 1]);
        int two = Integer.MAX_VALUE;
        if (n > 1)
            two = solve(n - 2, dp, heights) + Math.abs(heights[n] - heights[n - 2]);
        return dp[n] = Math.min(one, two);
    }
}
