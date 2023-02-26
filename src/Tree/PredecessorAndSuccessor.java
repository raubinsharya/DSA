package Tree;

import Utils.Node;
// https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
public class PredecessorAndSuccessor {

    private class Res {
        Node succ;
        Node pre;
    }

    public static void findPreSuc(Node root, Res p, Res s, int key) {
        if (root == null) return;
        findPre(root, p, key);
        findSuccess(root, s, key);
    }

    private static void findSuccess(Node root, Res s, int key) {
        if (root == null) return;
        if (root.data > key) {
            s.succ = root;
            findSuccess(root.left, s, key);
        } else findSuccess(root.right, s, key);
    }

    private static void findPre(Node root, Res p, int key) {
        if (root == null) return;
        if (root.data >= key) {
            findPre(root.left, p, key);
        } else {
            p.pre = root;
            findPre(root.right, p, key);
        }
    }
}
