package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/
public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        int num[] = new int[1];
        solve(root, num, "");
        return num[0];
    }

    private void solve(TreeNode root, int[] num, String s) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            num[0] += Integer.parseInt(s + root.val, 2);
            return;
        }
        solve(root.left, num, s + root.val);
        solve(root.right, num, s + root.val);
    }
}
