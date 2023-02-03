package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
// https://www.interviewbit.com/problems/path-to-given-node/
public class PathToGivenNode {
    public ArrayList<Integer> solve(TreeNode root, int node) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        solveTree(root, node, res);
        return res;
    }

    private boolean solveTree(TreeNode root, int node, ArrayList<Integer> res) {
        if (root == null) return false;
        res.add(root.val);
        if (root.val == node) return true;
        boolean left = solveTree(root.left, node, res);
        boolean right = solveTree(root.right, node, res);
        if (left || right) return true;
        res.remove(res.size() - 1);
        return false;
    }
}
