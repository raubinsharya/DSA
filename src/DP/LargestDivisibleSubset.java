package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int dp[] = new int[n + 1];
        int hash[] = new int[n + 1];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        int maxi = 0, lastIndex = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }
        list.add(nums[lastIndex]);
        while (nums[lastIndex]!= lastIndex){
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        return list;
    }
}
