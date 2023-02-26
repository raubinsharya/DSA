package Tree;

import Utils.TreeNode;

import java.util.Stack;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

public class TwoSum {

    private class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();
        private boolean isReverse = false;

        public BSTIterator(TreeNode root, boolean reverse) {
            this.isReverse = reverse;
            addAll(root);
        }

        private void addAll(TreeNode root) {
            while (root != null) {
                stack.add(root);
                if (isReverse) root = root.right;
                else root = root.left;
            }
        }

        public int next() {
            TreeNode next = stack.pop();
            if (isReverse) addAll(next.left);
            else addAll(next.right);
            return next.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {
            if (i + j == k) return true;
            if (i + j < k) {
                i = left.next();
            } else j = right.next();
        }
        return false;
    }
}
