package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
public class MaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int num[] = new int[1];
        num[0] = Integer.MIN_VALUE;
        solve(root, num);
        return num[0];
    }

    private int solve(TreeNode root, int[] num) {
        if (root == null) return 0;
        int left = Math.max(0, solve(root.left, num));
        int right = Math.max(0, solve(root.right, num));
        num[0] = Math.max(num[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
