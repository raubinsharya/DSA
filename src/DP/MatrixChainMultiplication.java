package DP;

import java.util.Arrays;

// https://www.codingninjas.com/codestudio/problems/matrix-chain-multiplication_975344?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
public class MatrixChainMultiplication {
    public static int matrixMultiplication(int[] arr, int N) {
        int dp[][] = new int[N][N];
        for (int row[] : dp) Arrays.fill(row, -1);
        return solveTopDown(1, N - 1, arr, dp);
    }

    private static int solveTopDown(int i, int j, int[] arr, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int maxi = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + solveTopDown(i, k, arr, dp) + solveTopDown(k + 1, j, arr, dp);
            maxi = Math.min(maxi, steps);
        }
        return dp[i][j] = maxi;
    }

    private static int solveBottomUp(int arr[], int n) {
        int dp[][] = new int[n][n];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                if(i == j) dp[i][j] = 0;
                int maxi = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    maxi = Math.min(maxi, steps);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n - 1];
    }
}
