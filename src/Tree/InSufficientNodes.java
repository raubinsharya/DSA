package Tree;

import Utils.Pair;
import Utils.TreeNode;
// https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/description/
public class InSufficientNodes {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) return null;
        boolean ans = solve(root, 0, limit);
        return ans ? null : root;
    }

    private boolean solve(TreeNode root, int sum, int limit) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (root.val + sum < limit) return true;
            else return false;
        }

        boolean left = solve(root.left, sum + root.val, limit);
        boolean right = solve(root.right, sum + root.val, limit);

        if (left) root.left = null;
        if (right) root.right = null;

        if (left && root.right == null) return true;
        if (right && root.left == null) return true;

        return left && right;
    }
}
