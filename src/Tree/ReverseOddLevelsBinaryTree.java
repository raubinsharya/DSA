package Tree;

import Utils.TreeNode;

// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
public class ReverseOddLevelsBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        solve(root.left, root.right, 1);
        return root;
    }

    private void solve(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) return;
        if (level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        solve(left.left, right.right, level + 1);
        solve(left.right, right.left, level + 1);
    }
}
