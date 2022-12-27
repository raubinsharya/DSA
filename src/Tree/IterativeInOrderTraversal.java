package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class IterativeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }
}
