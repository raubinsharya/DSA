package Tree;

import Utils.TreeNode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        return solve(root, p, q);
    }

    private TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root.val == p.val) return p;
        if (root == q || root.val == q.val) return q;

        TreeNode left = solve(root.left, p, q);
        TreeNode right = solve(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
