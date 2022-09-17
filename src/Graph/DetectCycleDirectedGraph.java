package Graph;

import java.util.ArrayList;
// Problem Link
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph

public class DetectCycleDirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int visited[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited) == true) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 2;
        for (int i : adj.get(node)) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited) == true) return true;
            } else if (visited[i] == 2) return true;
        }
        visited[node] = 1;
        return false;
    }
}
