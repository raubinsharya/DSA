package Tree;

import Utils.Pair;
import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SingleIterationTreeTraversal {
    public void preInPostOrderTraversal(TreeNode root) {
        if (root == null) return;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(root, 1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            if (pair.second == 1) {
                pre.add(pair.first.val);
                pair.second++;
                stack.add(pair);
                if (pair.first.left != null) stack.add(new Pair<>(pair.first.left, 1));
            } else if (pair.second == 2) {
                in.add(pair.first.val);
                pair.second++;
                stack.add(pair);
                if (pair.first.right != null) stack.add(new Pair<>(pair.first.right, 1));
            } else {
                post.add(pair.first.val);
            }
        }
    }
}
