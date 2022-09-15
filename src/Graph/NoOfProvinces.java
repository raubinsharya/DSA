package Graph;

import java.util.ArrayList;

/*
 Problem Link
 https://practice.geeksforgeeks.org/problems/number-of-provinces/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number_of_provinces
 */
public class NoOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        // Changing adj matrix to adj list
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        int res = 0;
        boolean visited[] = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                res++;
                dfs(adjList, visited, i);
            }
        }
        return res;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        for (int i : adj.get(node)) {
            if (!visited[i]) dfs(adj, visited, i);
        }
    }
}
