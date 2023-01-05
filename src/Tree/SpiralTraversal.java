package Tree;

import Utils.TreeNode;

import java.util.*;
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class SpiralTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean level = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (!level)
                    ds.add(temp.val);
                else ds.add(0, temp.val);
                if (temp.right != null) queue.add(temp.right);
                if (temp.left != null) queue.add(temp.left);
            }
            level = !level;
            res.add(ds);
        }
        return res;
    }
}
