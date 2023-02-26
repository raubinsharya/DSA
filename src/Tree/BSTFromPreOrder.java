package Tree;

import Utils.TreeNode;
// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
public class BSTFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        int index[] = new int[1];
        return solve(preorder, Integer.MAX_VALUE, index);
    }

    private TreeNode solve(int[] preorder, int maxValue, int index[]) {
        if (index[0] == preorder.length || preorder[index[0]] > maxValue) return null;
        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = solve(preorder, root.val, index);
        root.right = solve(preorder, maxValue, index);
        return root;
    }
}
