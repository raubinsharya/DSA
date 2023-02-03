package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/binary-tree-paths/
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        solve(root, res, "");
        return res;
    }

    private void solve(TreeNode root, List<String> res, String ds) {
        if (root == null) return;
        String ans = ds + root.val;
        if (root.left == null && root.right == null)
            res.add(ans);
        solve(root.left, res, ans + "->");
        solve(root.right, res, ans + "->");
    }
}
