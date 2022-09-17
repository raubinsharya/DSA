package Graph;

import java.util.ArrayList;
import java.util.Stack;
// Problem Link
// https://practice.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort
public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int res[] = new int[V];
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, adj, visited, stack);
        }
        for (int i = 0; i < V; i++) res[i] = stack.pop();
        return res;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int it : adj.get(node)) {
            if (!visited[it]) dfs(it, adj, visited, stack);
        }
        stack.add(node);
    }
}
