package Tree;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
public class ConstructBinaryTreeFromPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
        return root;
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inPos = inMap.get(root.val);
        int postLeft = inPos - inStart;
        root.left = buildTree(inorder, inStart, inPos - 1, postorder, postStart, postStart + postLeft - 1, inMap);
        root.right = buildTree(inorder, inPos + 1, inEnd, postorder, postStart + postLeft, postEnd - 1, inMap);
        return root;
    }
}
