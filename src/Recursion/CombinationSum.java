package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> ds = new LinkedList<>();
        solve(arr, target, 0, arr.length, ds, res);
        return res;
    }

    private void solve(int[] arr, int target, int idx, int n, LinkedList<Integer> ds, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }
        if (idx == n) return;
        if (target - arr[idx] >= 0) {
            ds.add(arr[idx]);
            solve(arr, target - arr[idx], idx, n, ds, res);
            ds.removeLast();
        }
        solve(arr, target, idx + 1, n, ds, res);

    }
}
