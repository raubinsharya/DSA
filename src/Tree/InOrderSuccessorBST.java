package Tree;

import Utils.Node;
// https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1
public class InOrderSuccessorBST {
    public Node inorderSuccessor(Node root, Node x) {
        if (root == null) return null;
        Node node[] = new Node[1];
        solve(root, x, node);
        return node[0];
    }

    private void solve(Node root, Node x, Node[] node) {
        if (root == null) return;
        if (root.data > x.data) {
            node[0] = root;
            solve(root.left, x, node);
        } else solve(root.right, x, node);
    }
}
