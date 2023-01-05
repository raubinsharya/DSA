package Tree;

import java.util.ArrayList;

import Utils.Node;
// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
public class BoundaryTraversal {

    private boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }

    private void addLeftBoundary(Node root, ArrayList<Integer> res) {
        if (root == null) return;
        if (!isLeaf(root)) res.add(root.data);
        if (root.left == null) addLeftBoundary(root.right, res);
        addLeftBoundary(root.left, res);
    }

    private void addRightBoundary(Node root, ArrayList<Integer> res) {
        if (root == null) return;
        if (root.right == null) addRightBoundary(root.left, res);
        addRightBoundary(root.right, res);
        if (!isLeaf(root)) res.add(root.data);
    }

    private void addLeaves(Node root, ArrayList<Integer> res) {
        if (root == null) return;
        if (isLeaf(root)) res.add(root.data);
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    public ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (isLeaf(node) == false) ans.add(node.data);
        addLeftBoundary(node.left, ans);
        addLeaves(node, ans);
        addRightBoundary(node.right, ans);
        return ans;
    }

}
