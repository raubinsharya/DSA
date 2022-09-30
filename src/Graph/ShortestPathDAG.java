package Graph;

import Utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// Problem link
// https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?page=1&category[]=Shortest%20Path&sortBy=submissions

public class ShortestPathDAG {
    public int[] shortestPath(int N, int M, int[][] edges) {
        int res[] = new int[N];
        ArrayList<ArrayList<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < N; i++) {
            adj.get(edges[i][0]).add(new Pair<>(edges[i][1], edges[i][2]));
        }

        boolean visited[] = new boolean[N];
        int dist[] = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(adj, visited, stack, i);
            }
        }
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;
        while (!stack.isEmpty()) {
            int i = stack.pop();
            for (Pair<Integer, Integer> node : adj.get(i)) {
                dist[node.first] = Math.min(dist[i] + node.second, dist[node.first]);
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) dist[i] = -1;
        }
        return dist;
    }

    private void dfs(ArrayList<ArrayList<Pair<Integer, Integer>>> adj, boolean[] visited, Stack<Integer> stack, int node) {
        visited[node] = true;
        for (Pair<Integer, Integer> i : adj.get(node)) {
            if (!visited[i.first]) dfs(adj, visited, stack, i.first);
        }
        stack.add(node);
    }
}
