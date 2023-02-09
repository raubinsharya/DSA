package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
public class MinDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int num[] = new int[1];
        num[0] = Integer.MAX_VALUE;
        solve(root, num, 0);
        return num[0];
    }

    private void solve(TreeNode root, int[] num, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            num[0] = Math.min(num[0], depth + 1);
        }
        solve(root.left, num, depth + 1);
        solve(root.right, num, depth + 1);
    }
}
