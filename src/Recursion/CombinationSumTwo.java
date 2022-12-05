package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
// https://leetcode.com/problems/combination-sum-ii/description/
public class CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> ds = new LinkedList<>();
        solve(arr, target, 0, arr.length, ds, res);
        return res;
    }

    private void solve(int[] arr, int target, int idx, int n, LinkedList<Integer> ds, List<List<Integer>> res) {
        if (target == 0) res.add(new ArrayList<>(ds));
        if (idx == n) return;
        for (int i = idx; i < n; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            if (target - arr[i] < 0) break;
            ds.add(arr[i]);
            solve(arr, target - arr[i], i + 1, n, ds, res);
            ds.removeLast();
        }
    }

}
