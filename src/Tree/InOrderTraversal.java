package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        solve(root, res);
        return res;
    }

    private void solve(TreeNode root, List<Integer> res) {
        if (root == null) return;
        solve(root.left, res);
        res.add(root.val);
        solve(root.right, res);
    }
}
