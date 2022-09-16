package Graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Problem Link
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph

public class DetectCycleUndirectedGraph {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkCycleUsingDFS(i, -1, visited, adj)) return true;
            }
        }
        return false;
    }

    private boolean checkCycleUsingDFS(int node, int parent, boolean visited[], ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int i : adj.get(node)) {
            if (!visited[i]) {
                if (checkCycleUsingDFS(i, node, visited, adj)) return true;
            } else if (i != parent) return true;

        }
        return false;
    }
}
