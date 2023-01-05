package Tree;

import Utils.Pair;
import Utils.TreeNode;

import java.util.*;

public class LeftViewTree {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> temp = queue.poll();
                if (temp.first.left != null) queue.offer(new Pair<>(temp.first.left, temp.second + 1));
                if (temp.first.right != null) queue.offer(new Pair<>(temp.first.right, temp.second + 1));
                treeMap.putIfAbsent(temp.second, temp.first.val);
            }
        }
        for (int node : treeMap.values()) res.add(node);
        return res;
    }
}
