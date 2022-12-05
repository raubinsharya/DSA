package Recursion;

import java.util.ArrayList;
import java.util.Collections;
// https://practice.geeksforgeeks.org/problems/subset-sums2234/1
public class SubsetSum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        Collections.sort(arr);
        solve(arr, 0, n, 0, res);
        return res;
    }

    private void solve(ArrayList<Integer> arr, int idx, int n, int sum, ArrayList<Integer> res) {
        if (idx == n) {
            res.add(sum);
            return;
        }
        solve(arr, idx + 1, n, sum + arr.get(idx), res); // pick condition
        solve(arr, idx + 1, n, sum, res); // not pick condition

    }
}
