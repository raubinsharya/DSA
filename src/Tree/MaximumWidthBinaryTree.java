package Tree;

import Utils.Pair;
import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/maximum-width-of-binary-tree/description/
public class MaximumWidthBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        int maxi = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int firstNode = 0;
            int lastNode = 0;
            int minNode = queue.peek().second;
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> temp = queue.poll();
                if (temp.first.left != null)
                    queue.offer(new Pair<>(temp.first.left, 2 * temp.second + 1 - minNode));
                if (temp.first.right != null)
                    queue.offer(new Pair<>(temp.first.right, 2 * temp.second + 2 - minNode));
                if (i == 0) firstNode = temp.second;
                if (i == size - 1) lastNode = temp.second;
                maxi = Math.max(maxi, lastNode - firstNode);
            }
        }
        return maxi + 1;
    }
}
