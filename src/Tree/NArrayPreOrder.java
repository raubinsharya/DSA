package Tree;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/

public class NArrayPreOrder {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        solve(root, list);
        return list;
    }

    private void solve(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (Node node : root.children) {
            list.add(node.val);
            solve(node, list);
        }
    }
}
