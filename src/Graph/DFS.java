package Graph;

import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        if (adj == null || adj.size() == 0) return dfs;
        boolean visited[] = new boolean[V + 1];
        dfs(adj, visited, dfs, 0);
        return dfs;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs, int node) {
        dfs.add(node);
        visited[node] = true;
        for (int num : adj.get(node)) {
            if (!visited[num]) {
                dfs(adj, visited, dfs, num);
            }
        }
    }
}
