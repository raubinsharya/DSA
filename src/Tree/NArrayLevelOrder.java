package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
public class NArrayLevelOrder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> _list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                _list.add(temp.val);
                for (Node node : temp.children) {
                    queue.offer(node);
                }
            }
            list.add(_list);
        }
        return list;
    }
}
