package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// https://leetcode.com/problems/find-duplicate-subtrees/description/
public class FindDuplicateSubTree {
    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return list;
        solve(root);
        return list;
    }

    private String solve(TreeNode root) {
        if (root == null) return "N";
        String left = solve(root.left);
        String right = solve(root.right);
        String curr = root.val + " " + left +" "+ right;
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        if (map.get(curr) == 2) list.add(root);
        return curr;
    }
}
