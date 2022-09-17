package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Problem Link
// https://leetcode.com/problems/find-eventual-safe-states/
// https://practice.geeksforgeeks.org/problems/eventual-safe-states/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=eventual-safe-states

public class SafeStates {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        int visited[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, visited);
            }
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == 1) res.add(i);
        }
        return res;
    }


    private boolean dfs(int node, List<List<Integer>> adj, int[] visited) {
        visited[node] = 2;
        for (int i : adj.get(node)) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited) == true) return true;
            } else if (visited[i] == 2) return true;
        }
        visited[node] = 1;
        return false;
    }

    private boolean dfs(int node, int[][] adj, int[] visited) {
        visited[node] = 2;
        for (int i : adj[node]) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited) == true) return true;
            } else if (visited[i] == 2) return true;
        }
        visited[node] = 1;
        return false;
    }

    // Leetcode
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int V = adj.length;
        List<Integer> res = new ArrayList<>();
        int visited[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, visited);
            }
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == 1) res.add(i);
        }
        return res;
    }
}
