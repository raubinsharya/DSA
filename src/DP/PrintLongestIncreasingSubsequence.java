package DP;

// https://leetcode.com/problems/longest-increasing-subsequence/description/

import java.util.Arrays;

public class PrintLongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 1);
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i] + dp[j], dp[i]);
                    maxi = Math.max(maxi, dp[i]);
                }
            }
        }
        return maxi;
    }

    public static void printLIS(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        int hash[] = new int[n + 1];
        int maxi = 0;
        int lastIndex = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            hash[i] = i;
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j] && 1 + dp[j] > dp[i]) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }
        System.out.println(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            System.out.println(nums[lastIndex]);
        }
    }

    public static void main(String[] args) {
        int nums[] = {5, 4, 11, 1, 16, 8};
        printLIS(nums);
    }
}
