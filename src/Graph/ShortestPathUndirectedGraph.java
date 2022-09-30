package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1?page=1&sortBy=accuracy&query=page1sortByaccuracy

public class ShortestPathUndirectedGraph {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        dist[src] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i : adj.get(node)) {
                if (dist[node] + 1 < dist[i]) {
                    dist[i] = dist[node] + 1;
                    queue.offer(i);
                }
            }
        }
        for(int i=0;i<n;i++) if(dist[i]==Integer.MAX_VALUE) dist[i] =-1;
        return dist;
    }
}
