package Graph;

import java.util.ArrayList;
import java.util.Stack;

// Problem Link
// https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

public class KosarajuAlgoSCC {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> topo = new Stack<>();
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
            if (!visited[i]) {
                dfs(i, adj, visited, topo);
            }
        }
        for (int i = 0; i < V; i++) {
            visited[i] = false;
            for (int node : adj.get(i)) {
                revAdj.get(node).add(i);
            }
        }
        int res = 0;
        while (!topo.isEmpty()) {
            int node = topo.pop();
            if (!visited[node]) {
                res++;
                revDFS(node, visited, revAdj);
            }
        }
        return res;
    }

    private void revDFS(int node, boolean[] visited, ArrayList<ArrayList<Integer>> revAdj) {
        visited[node] = true;
        for (int it : revAdj.get(node)) {
            if (!visited[it]) {
                revDFS(it, visited, revAdj);
            }
        }
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> topo) {
        visited[node] = true;
        for (int it : adj.get(node)) {
            if (!visited[it]) {
                dfs(it, adj, visited, topo);
            }
        }
        topo.add(node);
    }
}
