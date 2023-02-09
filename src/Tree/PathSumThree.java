package Tree;

import Utils.TreeNode;

// https://leetcode.com/problems/path-sum-iii/description/
public class PathSumThree {
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        solve(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    private void solve(TreeNode root, int targetSum, long sum) {
        if (root == null) return;
        if (targetSum == sum + root.val) res++;
        solve(root.left, targetSum, sum + root.val);
        solve(root.right, targetSum, sum + root.val);
    }
}
