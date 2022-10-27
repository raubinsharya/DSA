package DP;

// https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

import java.util.Arrays;

public class PartitionSetIntoTwoSubsetWithMinimumAbsoluteSumDifference {
    public static int minSubsetSumDifference(int[] arr, int n) {
        int sum = Arrays.stream(arr).sum();
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = true;
        if (sum >= arr[0]) dp[0][arr[0]] = true;
        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= sum; target++) {
                boolean pick = false;
                if (target >= arr[index]) pick = dp[index - 1][target - arr[index]];
                boolean notPick = dp[index - 1][target];
                dp[index][target] = pick | notPick;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (dp[n - 1][i]) {
                min = Math.min(min, Math.abs((sum - i) - i));
            }
        }
        return min;
    }
}
