package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/binary-tree-tilt/description/
public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        int num[] = new int[1];
        solve(root, num);
        return num[0];
    }

    private int solve(TreeNode root, int[] num) {
        if (root == null) return 0;
        int left = solve(root.left, num);
        int right = solve(root.right, num);
        num[0] += Math.abs(left - right);
        return root.val + left + right;
    }
}