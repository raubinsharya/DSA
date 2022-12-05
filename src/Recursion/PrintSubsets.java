package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// https://leetcode.com/problems/subsets/description/
public class PrintSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> ds = new LinkedList<>();
        solve(nums, 0, nums.length, ds, res);
        return res;
    }

    private void solve(int[] nums, int idx, int n, LinkedList<Integer> ds, List<List<Integer>> res) {
        if (idx == n) {
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[idx]);
        solve(nums, idx + 1, n, ds, res);
        ds.removeLast();
        solve(nums, idx + 1, n, ds, res);
    }
}
