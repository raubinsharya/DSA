package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        solve(root, res);
        return res;
    }

    private void solve(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        solve(root.left, res);
        solve(root.right, res);
    }
}
