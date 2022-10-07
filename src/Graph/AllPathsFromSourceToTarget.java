package Graph;

import java.util.ArrayList;
import java.util.List;

// Problem Link
// https://leetcode.com/problems/all-paths-from-source-to-target/description/

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(graph, res, temp, 0);
        return res;
    }

    private void solve(int[][] graph, List<List<Integer>> res, List<Integer> temp, int node) {
        temp.add(node);
        for (int it : graph[node]) {
            solve(graph, res, temp, it);
            if (it == graph.length - 1) res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
        }
    }
}
