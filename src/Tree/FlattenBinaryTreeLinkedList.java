package Tree;

import Utils.TreeNode;
import java.util.Stack;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
public class FlattenBinaryTreeLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode node[] = new TreeNode[1];
        solveRec(root, node);
    }

    private void solveRec(TreeNode root, TreeNode[] node) {
        if (root == null) return;
        solveRec(root.right, node);
        solveRec(root.left, node);
        root.right = node[0];
        root.left = null;
        node[0] = root;
    }

    private void solveIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
            if (!stack.isEmpty()) node.right = stack.peek();
            node.left = null;
        }
    }

    private void solveMorris(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode prev = node.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }

}
