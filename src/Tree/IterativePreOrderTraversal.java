package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
public class IterativePreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null) stack.add(temp.right);
            if (temp.left != null) stack.add(temp.left);
        }
        return res;
    }
}
