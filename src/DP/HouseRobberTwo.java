package DP;

// https://leetcode.com/problems/house-robber-ii/description/

public class HouseRobberTwo {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int one[] = new int[n];
        int two[] = new int[n];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) one[x++] = nums[i];
            if (i != n - 1) two[y++] = nums[i];
        }
        return Math.max(solveBottomUpWithSpaceOptimization(n, one), solveBottomUpWithSpaceOptimization(n, two));
    }

    private static int solveBottomUpWithSpaceOptimization(int n, int nums[]) {
        int one = nums[0];
        int two = 0;
        for (int i = 1; i < n; i++) {
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
