package Tree;

import Utils.TreeNode;

// https://leetcode.com/problems/sum-of-left-leaves/description/
public class SumLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int num[] = new int[1];
        solve(root, num, false);
        return num[0];
    }

    private void solve(TreeNode root, int[] num, boolean isLeft) {
        if (root == null) return;
        if (isLeft) {
            if (root.left == null && root.right == null) {
                num[0] += root.val;
            }
        }
        solve(root.left, num, true);
        solve(root.right, num, false);
    }
}
