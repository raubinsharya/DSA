package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/symmetric-tree/description/
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return solve(root.left, root.right);
    }

    private boolean solve(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return solve(left.left, right.right) && solve(left.right, right.left);
    }
}
