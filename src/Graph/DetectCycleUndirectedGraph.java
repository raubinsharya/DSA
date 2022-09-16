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
                if (checkCycleUsingBFS(adj, visited, i)) return true;
            }
        }
        return false;
    }

    private boolean checkCycleUsingBFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) {
        visited[src] = true;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(src, -1));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int node = pair.row;
            int parent = pair.col;
            for (int i : adj.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(new Pair<>(i, node));
                } else if (parent != i) {
                    return true;
                }
            }
        }
        return false;
    }
}
