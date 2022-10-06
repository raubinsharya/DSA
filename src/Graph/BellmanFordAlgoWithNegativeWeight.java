package Graph;

import java.util.ArrayList;
import java.util.Arrays;

// Problem Link
// https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1

public class BellmanFordAlgoWithNegativeWeight {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        int cycle = 0;
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];
                if (dist[u] + wt < dist[v]) dist[v] = dist[u] + wt;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            if (dist[u] + wt < dist[v]) return 1;
        }
        return cycle;
    }
}
