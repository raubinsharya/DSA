package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
public class SecondMinimumNodeBinaryTree {
    long first = Long.MAX_VALUE, second = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        solve(root);
        return second == Long.MAX_VALUE ? -1 : (int) second;
    }

    private void solve(TreeNode root) {
        if (root == null) return;
        first = Math.min(first, root.val);
        if (root.val > first && root.val < second && root.val != first) {
            second = root.val;
        }
        solve(root.left);
        solve(root.right);
    }
}
