package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/permutations/description/

public class PrintAllPermutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> ds = new LinkedList<>();
        boolean mark[] = new boolean[nums.length];
        // solveOne(nums, nums.length, ds, res, mark);
        solveTwo(nums, 0, nums.length, res);
        return res;
    }

    private void solveOne(int[] nums, int n, LinkedList<Integer> ds, List<List<Integer>> res, boolean[] mark) {
        if (ds.size() == n) res.add(new ArrayList<>(ds));
        for (int i = 0; i < n; i++) {
            if (!mark[i]) {
                ds.add(nums[i]);
                mark[i] = true;
                solveOne(nums, n, ds, res, mark);
                mark[i] = false;
                ds.removeLast();
            }
        }
    }

    private void solveTwo(int nums[], int idx, int n, List<List<Integer>> res) {
        if (idx == n) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            res.add(temp);
            return;
        }
        for (int i = idx; i < n; i++) {
            swap(nums, i, idx);
            solveTwo(nums, i + 1, n, res);
            swap(nums, i, idx);
        }
    }

    private void swap(int nums[], int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
