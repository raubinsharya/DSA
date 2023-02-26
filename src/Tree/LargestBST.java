package Tree;

import Utils.Node;
import Utils.Pairs;
// https://practice.geeksforgeeks.org/problems/largest-bst/1
public class LargestBST {
    static int largestBst(Node root) {
        if (root == null) return 0;
        Pairs<Integer, Integer, Integer> pairs = solve(root);
        return pairs.third;
    }

    private static Pairs<Integer, Integer, Integer> solve(Node root) {
        if (root == null) return new Pairs<>(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Pairs<Integer, Integer, Integer> left = solve(root.left);
        Pairs<Integer, Integer, Integer> right = solve(root.right);
        if (left.second < root.data && right.first > root.data) {
            return new Pairs<>(Math.min(left.first, root.data), Math.max(root.data, right.second), left.third + right.third + 1);
        }
        return new Pairs<>(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.third, right.third));
    }
}
