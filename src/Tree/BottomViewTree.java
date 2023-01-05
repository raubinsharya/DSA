package Tree;

import Utils.BinaryTreeNode;
import Utils.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
// https://www.codingninjas.com/codestudio/problems/bottom-view-of-binary-tree_893110
public class BottomViewTree {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
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
                treeMap.put(temp.second, temp.first.val);
            }
        }
        for (int node : treeMap.values()) res.add(node);
        return res;
    }
}
