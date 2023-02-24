package Tree;

import Utils.Node;
// https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
public class KthLargestElementBST {
    public int kthLargest(Node root, int k) {
        if (root == null) return 0;
        int num[] = new int[1];
        return solve(root, num, k);
    }

    private int solve(Node root, int[] num, int k) {
        if (root == null) return 0;
        int right = solve(root.right, num, k);
        num[0]++;
        if (num[0] == k) return root.data;
        int left = solve(root.left, num, k);
        if (right > 0) return right;
        if (left > 0) return left;
        return 0;
    }
}
