package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/longest-univalue-path/description/
public class LongestUniValuePath {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        solve(root, -1001, 0);
        longestUnivaluePath(root.left);
        longestUnivaluePath(root.right);
        return max;
    }

    private int solve(TreeNode root, int prevVal, int length) {
        if (root == null) return 0;
        if (prevVal != -1001) {
            if (root.val != prevVal) {
                return 0;
            }
        }
        int left = solve(root.left, root.val, length + 1);
        int right = solve(root.right, root.val, length + 1);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}
