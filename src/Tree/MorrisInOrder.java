package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class MorrisInOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        if (root == null) return inOrder;
        TreeNode node = root;

        while (node != null) {
            if (node.left == null) {
                inOrder.add(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    inOrder.add(node.val);
                    node = node.right;
                }
            }
        }
        return inOrder;
    }
}
