package DP;

import java.util.ArrayList;

// https://leetcode.com/problems/house-robber/description/

public class HouseRobber {
    public int rob(int[] nums) {
        return solveBottomUpWithSpaceOptimization(nums.length - 1, nums);
    }

    private static int solveBottomUpWithSpaceOptimization(int n, int nums[]) {
        int one = nums[0];
        int two = 0;
        for (int i = 1; i <= n; i++) {
            int first = nums[i];
            if (i > 1)
                first += two;
            int second = one;
            two = one;
            one = Math.max(first, second);
        }
        return one;
    }
}
