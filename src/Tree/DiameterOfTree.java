package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterOfTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int num[] = new int[1];
        solve(root, num);
        return num[0];
    }

    private int solve(TreeNode root, int num[]) {
        if (root == null) return 0;
        int left = solve(root.left, num);
        int right = solve(root.right, num);
        num[0] = Math.max(num[0], left + right);
        return Math.max(left, right) + 1;
    }
}
