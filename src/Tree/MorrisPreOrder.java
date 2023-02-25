package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/description/

public class MorrisPreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) return preOrder;
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                preOrder.add(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node) prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    preOrder.add(node.val);
                    node = node.left;
                } else {
                    prev.right = null;
                    node = node.right;
                }
            }
        }
        return preOrder;
    }
}
