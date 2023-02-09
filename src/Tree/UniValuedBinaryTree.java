package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/univalued-binary-tree/description/
public class UniValuedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return false;
        return solve(root, root.val);
    }

    private boolean solve(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        boolean left = solve(root.left, root.val);
        boolean right = solve(root.right, root.val);
        return left && right;
    }
}
