package Tree;

// https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457

public class FloorBST {
    public static int floorInBST(TreeNode<Integer> root, int X) {
        if (root == null) return -1;
        int right = floorInBST(root.right, X);
        if (right > -1) return right;
        if (X >= root.data) return root.data;
        int left = floorInBST(root.left, X);
        return left;
    }
}
