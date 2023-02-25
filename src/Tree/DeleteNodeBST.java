package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/delete-node-in-a-bst/description/
public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            return deleteHelper(root, key);
        }
        TreeNode node = root;
        while (node != null) {
            if (key < node.val) {
                if (node.left != null && node.left.val == key) {
                    node.left = deleteHelper(node.left, key);
                    break;
                } else node = node.left;
            } else {
                if (node.right != null && node.right.val == key) {
                    node.right = deleteHelper(node.right, key);
                    break;
                } else node = node.right;
            }
        }
        return root;
    }

    private TreeNode deleteHelper(TreeNode root, int key) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        while (leftChild.right != null) leftChild = leftChild.right;
        leftChild.right = rightChild;
        return root.left;
    }
}
