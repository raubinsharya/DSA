package Tree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
public class NArrayPostOrder {

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        solve(root, list);
        list.add(root.val);
        return list;
    }

    private void solve(Node root, List<Integer> list) {
        if (root == null) return;
        for (Node node : root.children) {
            solve(node, list);
        }
        list.add(root.val);
    }
}
