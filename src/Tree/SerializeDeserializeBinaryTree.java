package Tree;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        String res = "";
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp == null) res += "# ";
                else {
                    res += temp.val + " ";
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String arr[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < arr.length; i++) {
            TreeNode node = queue.poll();
            if (!arr[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(node.left);
            }
            if (!arr[++i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(node.right);
            }
        }
        return root;
    }
}
