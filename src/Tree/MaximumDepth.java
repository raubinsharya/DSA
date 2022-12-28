package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        return solve(root);
    }

    private int solve(TreeNode root) {
        if (root == null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        return Math.max(left, right) + 1;
    }
}
