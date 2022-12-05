package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/description/
public class SubsetSumTwo {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> ds = new LinkedList<>();
        res.add(new ArrayList<>());
        solve(nums, 0, nums.length, ds, res);
        return res;
    }

    private void solve(int[] nums, int idx, int n, LinkedList<Integer> ds, List<List<Integer>> res) {
        for (int i = idx; i < n; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            res.add(new ArrayList<>(ds));
            solve(nums, i + 1, n, ds, res);
            ds.removeLast();
        }
    }
}
