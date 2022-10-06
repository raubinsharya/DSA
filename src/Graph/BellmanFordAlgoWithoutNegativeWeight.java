package Graph;

import java.util.ArrayList;
import java.util.Arrays;

// Problem Link
// https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1#_=_

public class BellmanFordAlgoWithoutNegativeWeight {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < adj.size(); j++) {
                int u = adj.get(j).get(0);
                int v = adj.get(j).get(1);
                int wt = adj.get(j).get(2);
                if (dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }
        return dist;
    }
}
