package Tree;

import java.util.List;

// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/

class Node {
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
};

public class MaxDepthNTree {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int num[] = new int[1];
        solve(root, num, 0);
        return num[0];
    }

    private void solve(Node root, int[] num, int depth) {
        if (root == null) return;
        num[0] = Math.max(num[0], depth + 1);
        for (Node node : root.children) {
            solve(node, num, depth + 1);
        }
    }
}
