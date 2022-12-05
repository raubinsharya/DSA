package Recursion;

import java.util.*;

// https://leetcode.com/problems/permutations-ii/description/
public class PrintAllPermutationTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solveOne(nums, 0, nums.length, res);
        return res;
    }

    private void solveTwo(int[] nums, int idx, int n, LinkedList<Integer> ds, List<List<Integer>> res, boolean[] check) {
        if (ds.size() == n) {
            res.add(new ArrayList<>(ds));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                if (set.add(nums[i])) {
                    check[i] = true;
                    ds.add(nums[i]);
                    solveTwo(nums, idx, n, ds, res, check);
                    ds.removeLast();
                    check[i] = false;
                }
            }
        }
    }


    private void solveOne(int nums[], int idx, int n, List<List<Integer>> res) {
        if (idx == n) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            res.add(temp);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < n; i++) {
            if (set.add(nums[i])) {
                swap(nums, i, idx);
                solveOne(nums, idx + 1, n, res);
                swap(nums, idx, i);
            }
        }
    }

    public void swap(int arr[], int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
