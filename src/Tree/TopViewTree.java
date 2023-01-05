package Tree;

import Utils.BinaryTreeNode;
import Utils.Pair;

import java.util.*;
// https://www.codingninjas.com/codestudio/problems/top-view-of-the-tree_799401
public class TopViewTree {
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Queue<Pair<BinaryTreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<BinaryTreeNode, Integer> temp = queue.poll();
                if (temp.first.left != null) queue.offer(new Pair<>(temp.first.left, temp.second - 1));
                if (temp.first.right != null) queue.offer(new Pair<>(temp.first.right, temp.second + 1));
                treeMap.putIfAbsent(temp.second, temp.first.val);
            }
        }
        for (int node : treeMap.values()) res.add(node);
        return res;
    }
}
