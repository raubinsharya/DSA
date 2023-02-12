package Tree;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
public class NArrayPostOrder {
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
