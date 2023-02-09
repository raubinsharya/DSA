package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/path-sum-ii/description/
public class PathSumTwo {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> temp = new ArrayList<>();
        solve(root, targetSum, res, temp, 0);
        return res;
    }

    private void solve(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> temp, int sum) {
        if (root == null) return;
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == sum + root.val) {
                res.add(new ArrayList<>(temp));
            }
        }
        solve(root.left, targetSum, res, temp, sum + root.val);
        solve(root.right, targetSum, res, temp, sum + root.val);
        temp.remove(temp.size() - 1);
    }
}
