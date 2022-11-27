package DP;
// https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        int count[] = new int[n + 1];
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                } else if (nums[i] > nums[j] && dp[i] == dp[j] + 1) {
                    count[i] += count[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) cnt += count[i];
        }
        return cnt;
    }
}
