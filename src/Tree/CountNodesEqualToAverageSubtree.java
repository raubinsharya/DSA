package Tree;

import Utils.Pair;
import Utils.TreeNode;

// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/
public class CountNodesEqualToAverageSubtree {
    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;
        int num[] = new int[1];
        solve(root, num);
        return num[0];
    }

    private Pair<Integer, Integer> solve(TreeNode root, int num[]) {
        if (root == null) return new Pair<>(0, 0);
        Pair<Integer, Integer> left = solve(root.left, num);
        Pair<Integer, Integer> right = solve(root.right, num);
        int sum = left.first + right.first + root.val;
        int count = left.second + right.second + 1;
        if (root.val == sum / count) {
            num[0]++;
        }
        return new Pair<>(sum, count);
    }
}
