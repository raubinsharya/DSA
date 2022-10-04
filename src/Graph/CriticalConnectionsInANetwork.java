package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Tarjan's Algorithm for strongly connected component (SCC)
// problem link
// https://leetcode.com/problems/critical-connections-in-a-network/description/

public class CriticalConnectionsInANetwork {
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> list : connections) {
            adj.get(list.get(0)).add(list.get(1));
            adj.get(list.get(1)).add(list.get(0));
        }
        boolean visited[] = new boolean[n];
        int low[] = new int[n];
        int tin[] = new int[n];
        int timer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) dfs(0, 0, adj, visited, low, tin, res, timer);
        }
        return res;
    }

    private static void dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited, int[] low, int[] tin, List<List<Integer>> res, int timer) {
        visited[node] = true;
        low[node] = timer;
        tin[node] = timer++;
        for (int it : adj.get(node)) {
            if (it == parent) continue;
            if (!visited[it]) {
                dfs(it, node, adj, visited, low, tin, res, timer);
                low[node] = Math.min(low[it], low[node]);
                if (low[it] > tin[node]) {
                    res.add(Arrays.asList(node, it));
                }
            } else low[node] = Math.min(low[node], tin[it]);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) adj.add(new ArrayList<>());
        adj.get(0).add(0);
        adj.get(0).add(1);
        adj.get(1).add(1);
        adj.get(1).add(2);
        adj.get(2).add(2);
        adj.get(2).add(0);
        adj.get(3).add(1);
        adj.get(3).add(3);
        System.out.println(criticalConnections(4, adj));
    }
}
