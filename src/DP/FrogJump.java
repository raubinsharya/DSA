package DP;

// Problem Link
// https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1


public class FrogJump {
    public static int frogJump(int n, int heights[]) {
        int dp[] = new int[n + 1];
        return solveBottomUpWithSpaceOptimization(n, heights);
        // return solveTopDown(n - 1, dp, heights);
    }


    // Top-down approach
    public static int solveTopDown(int n, int[] dp, int[] heights) {
        if (n == 0) return 0;
        if (dp[n] != 0) return dp[n];
        int one = solveTopDown(n - 1, dp, heights) + Math.abs(heights[n] - heights[n - 1]);
        int two = Integer.MAX_VALUE;
        if (n > 1)
            two = solveTopDown(n - 2, dp, heights) + Math.abs(heights[n] - heights[n - 2]);
        return dp[n] = Math.min(one, two);
    }

    // Bottom-Up approach without space optimization
    private static int solveBottomUpWithoutSpaceOptimization(int n, int[] heights) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int one = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int two = Integer.MAX_VALUE;
            if (i > 1) two = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(one, two);
        }
        return dp[n - 1];
    }

    // Bottom-Up approach with space optimization
    private static int solveBottomUpWithSpaceOptimization(int n, int[] heights) {
        int first = 0;
        int second = 0;
        for (int i = 1; i < n; i++) {
            int one = first + Math.abs(heights[i] - heights[i - 1]);
            int two = Integer.MAX_VALUE;
            if (i > 1) two = second + Math.abs(heights[i] - heights[i - 2]);
            second = first;
            first = Math.min(one, two);
        }
        return first;
    }

}
