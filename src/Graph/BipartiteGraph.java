package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Problem Link
// https://practice.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bipartite-graph

public class BipartiteGraph {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                // if (checkBFS(color, adj, i) == false) return false;
                if (!checkDFS(color, adj, i, 0)) return false;
            }
        }
        return true;
    }

    boolean checkBFS(int color[], ArrayList<ArrayList<Integer>> adj, int src) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        color[src] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i : adj.get(node)) {
                if (color[i] == -1) {
                    queue.offer(i);
                    color[i] = 1 - color[node];
                } else if (color[i] == color[node]) return false;
            }
        }
        return true;
    }

    boolean checkDFS(int color[], ArrayList<ArrayList<Integer>> adj, int node, int col) {
        color[node] = col;
        for (int i : adj.get(node)) {
            if (color[i] == -1) {
                if (!checkDFS(color, adj, i, 1 - col)) return false;
            } else if (color[i] == col) return false;
        }
        return true;
    }
}
