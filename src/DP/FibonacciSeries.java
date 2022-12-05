package DP;

public class FibonacciSeries {
    public int fib(int n) {
        int dp[] = new int[n + 1];
        return solveTopDown(n, dp);
    }

    private int solveTopDown(int n, int dp[]) {
        if (n == 1) return 1;
        if (n < 1) return 0;
        if (dp[n] != 0) return dp[n];
        return dp[n] = solveTopDown(n - 1, dp) + solveTopDown(n - 2, dp);
    }

    private static int solveBottomUp(int n) {
        int dp[] = new int[n + 2];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
