package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/validate-binary-search-tree/description/
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.val <= minValue || root.val >= maxValue) return false;
        boolean left = check(root.left, minValue, root.val);
        boolean right = check(root.right, root.val, maxValue);
        return left && right;
    }
}
