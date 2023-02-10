package Tree;

import Utils.TreeNode;

public class ChildrenSumProperty {
    public void makeChildrenSumProperty(TreeNode root) {
        if (root == null) return;
        solve(root);
    }

    private int solve(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            if (root.left.val + root.right.val < root.val) {
                root.left.val = root.val;
                root.right.val = root.val;
            } else root.val = root.left.val + root.right.val;
        }
        int left = solve(root.left);
        int right = solve(root.right);
        root.val = Math.max(root.val, left + right);
        return root.val;
    }
}
