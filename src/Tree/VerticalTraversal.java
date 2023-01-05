package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> treeMap = new TreeMap<>();
        if (root == null) return res;
        solve(root, treeMap, 0, 0);
        for (TreeMap<Integer, PriorityQueue<Integer>> map : treeMap.values()) {
            List<Integer> ds = new ArrayList<>();
            for (PriorityQueue<Integer> pq : map.values()) {
                while (!pq.isEmpty()) {
                    ds.add(pq.poll());
                }
            }
            res.add(ds);
        }
        return res;
    }

    private void solve(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int vertical, int level) {
        if (root == null) return;
        TreeMap<Integer, PriorityQueue<Integer>> tempMap = map.getOrDefault(vertical, new TreeMap<>());
        PriorityQueue<Integer> queue = tempMap.getOrDefault(level, new PriorityQueue<>());
        queue.add(root.val);
        tempMap.put(level, queue);
        map.put(vertical, tempMap);
        solve(root.left, map, vertical - 1, level + 1);
        solve(root.right, map, vertical + 1, level + 1);
    }
}
