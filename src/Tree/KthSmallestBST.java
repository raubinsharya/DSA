package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
public class KthSmallestBST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        int num[] = new int[1];
        return solve(root, num, k);
    }

    private int solve(TreeNode root, int[] num, int k) {
        if (root == null) return -1;
        int left = solve(root.left, num, k);
        num[0]++;
        if (num[0] == k) return root.val;
        int right = solve(root.right, num, k);
        if (left > 0) return left;
        if (right > 0) return right;
        return 0;
    }
}
