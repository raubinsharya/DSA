package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
public class MaximumProductSplitBinaryTree {
    public int maxProduct(TreeNode root) {
        if (root == null) return 0;
        long num[] = new long[1];
        num[0] = 0;
        int sum = getSum(root);
        solve(root, num, sum);
        return (int) (num[0] % 1000000007);
    }

    private long solve(TreeNode root, long[] num, int sum) {
        if (root == null) return 0;
        long left = solve(root.left, num, sum);
        long right = solve(root.right, num, sum);
        long currentSum = left + right + root.val;
        num[0] = Math.max(num[0], (sum - currentSum) * currentSum);
        return currentSum;
    }


    private int getSum(TreeNode root) {
        if (root == null) return 0;
        int left = getSum(root.left);
        int right = getSum(root.right);
        return left + right + root.val;
    }
}
