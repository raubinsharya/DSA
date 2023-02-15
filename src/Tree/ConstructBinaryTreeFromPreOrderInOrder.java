package Tree;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
public class ConstructBinaryTreeFromPreOrderInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = solve(preorder, 0, preorder.length - 1, inorder, 0, inorder.length, inMap);
        return root;
    }

    private TreeNode solve(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd || preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inPos = inMap.get(root.val);
        int inSize = inPos - inStart;
        root.left = solve(preorder, preStart + 1, preStart + inSize, inorder, inStart, inPos - 1, inMap);
        root.right = solve(preorder, preStart + 1 + inSize, preEnd, inorder, inPos + 1, inEnd, inMap);
        return root;
    }
}
