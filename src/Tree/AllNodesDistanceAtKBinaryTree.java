package Tree;

import Utils.TreeNode;

import java.util.*;
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
public class AllNodesDistanceAtKBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                    parent.put(temp.left, temp);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    parent.put(temp.right, temp);
                }
            }
        }
        solve(target, k, 0, visited, parent, res);
        return res;
    }

    private void solve(TreeNode root, int k, int distance, HashMap<TreeNode, Boolean> visited, HashMap<TreeNode, TreeNode> parent, List<Integer> res) {
        if (root == null || visited.getOrDefault(root, false)) return;
        if (k == distance) {
            res.add(root.val);
            return;
        }
        visited.put(root, true);
        solve(root.left, k, distance + 1, visited, parent, res);
        solve(root.right, k, distance + 1, visited, parent, res);
        solve(parent.get(root), k, distance + 1, visited, parent, res);
    }
}
