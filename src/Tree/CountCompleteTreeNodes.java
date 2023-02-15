package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/count-complete-tree-nodes/description/
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = countLeftNodes(root);
        int right = countRightNodes(root);
        if (left == right)
            return (int) (Math.pow(2, left) - 1);
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int countRightNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    private int countLeftNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}
