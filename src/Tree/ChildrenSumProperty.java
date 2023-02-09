package Tree;

import Utils.Node;
// https://practice.geeksforgeeks.org/problems/children-sum-parent/1
public class ChildrenSumProperty {
    public static int isSumProperty(Node root) {
        if (root == null) return 1;
        return solve(root) > 0 ? 1 : 0;
    }

    private static int solve(Node root) {
        if (root.left == null && root.right == null) return root.data;
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = solve(root.left);
        }
        if (left == -1) return -1;
        if (root.right != null) {
            right = solve(root.right);
        }
        if (right == -1) return -1;
        if (root.data != left + right) return -1;
        return root.data;
    }
}
