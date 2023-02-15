package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import Utils.Node;

// https://practice.geeksforgeeks.org/problems/burning-tree/1

public class BurningTree {
    public static int minTime(Node root, int target) {
        int res = -1;
        if (root == null) return 0;
        Map<Node, Node> parent = new HashMap<>();
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node node = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                if (temp.data == target) node = temp;
                if (temp.left != null) {
                    queue.offer(temp.left);
                    parent.putIfAbsent(temp.left, temp);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    parent.putIfAbsent(temp.right, temp);
                }
            }
        }
        queue.clear();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                visited.putIfAbsent(temp, true);
                if (temp.left != null && !visited.getOrDefault(temp.left, false)) queue.offer(temp.left);
                if (temp.right != null && !visited.getOrDefault(temp.right, false)) queue.offer(temp.right);
                Node _parent = parent.getOrDefault(temp, null);
                if (_parent != null && !visited.getOrDefault(_parent, false)) queue.offer(_parent);
            }
        }
        return res;
    }
}
