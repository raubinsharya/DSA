package Tree;


// https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464
public class CeilBST {

    private class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static int findCeil(TreeNode<Integer> root, int x) {
        if (root == null) return -1;
        int left = findCeil(root.left, x);
        if (left > -1) return left;
        if (root.data >= x) return root.data;
        int right = findCeil(root.right, x);
        if (right > -1) return right;
        return -1;
    }
}
