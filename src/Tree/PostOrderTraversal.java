package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        solve(root, res);
        return res;
    }

    private void solve(TreeNode root, List<Integer> res) {
        if (root == null) return;
        solve(root.left, res);
        solve(root.right, res);
        res.add(root.val);
    }
}
