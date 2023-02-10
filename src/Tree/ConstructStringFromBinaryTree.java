package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/construct-string-from-binary-tree/description/
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        solve(root, sb);
        return sb.toString();
    }

    private void solve(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            return;
        }
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            solve(root.left, sb);
            sb.append(")");
        }
        if (root.left == null && root.right != null) sb.append("()");
        if (root.right != null) {
            sb.append("(");
            solve(root.right, sb);
            sb.append(")");
        }
    }
}
