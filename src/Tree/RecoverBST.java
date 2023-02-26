package Tree;

import Utils.TreeNode;

// https://leetcode.com/problems/recover-binary-search-tree/description/

public class RecoverBST {
    private TreeNode first, middle, last;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        solve(root);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void solve(TreeNode root) {
        if (root == null) return;
        solve(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else last = root;

        }
        prev = root;
        solve(root.right);
    }
}
