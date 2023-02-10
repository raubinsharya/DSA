package Tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/find-mode-in-binary-search-tree/
public class ModeBST {
    TreeNode prev = null;
    int currentCnt = 1, maxi = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> set = new ArrayList<>();
        solve(root, set);
        int arr[] = new int[set.size()];
        int i = 0;
        for (int num : set) arr[i++] = num;
        return arr;
    }

    private void solve(TreeNode root, List<Integer> list) {
        if (root == null) return;
        solve(root.left, list);
        if (prev != null) {
            if (root.val == prev.val) currentCnt++;
            else currentCnt = 1;
        }
        prev = new TreeNode(root.val);
        if (currentCnt > maxi) {
            maxi = currentCnt;
            list.clear();
            list.add(root.val);
        } else if (currentCnt == maxi) list.add(root.val);
        solve(root.right, list);
    }

}
