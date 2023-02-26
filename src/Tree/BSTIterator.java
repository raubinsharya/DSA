package Tree;

import Utils.TreeNode;

import java.util.Stack;
// https://leetcode.com/problems/binary-search-tree-iterator/description/
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        addAll(root);
    }

    private void addAll(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode next = stack.pop();
        addAll(next.right);
        return next.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
