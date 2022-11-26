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
        Arrays.fill(dp, 1);
        Arrays.fill(hash, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        hash[i] = nums[j];
                    }
                }
            }
        }
        for (int num : hash) {
            if (num > -1) System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int nums[] = {5, 4, 11, 1, 16, 18};
        printLIS(nums);
    }
}
