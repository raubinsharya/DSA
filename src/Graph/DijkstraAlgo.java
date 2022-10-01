package Graph;

import Utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-dijkstra-set-1-adjacency-matrix

public class DijkstraAlgo {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.first));
        pq.offer(new Pair<>(0, S));
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            for (ArrayList<Integer> arr : adj.get(pair.second)) {
                int node = arr.get(0);
                int wt = arr.get(1);
                if (pair.first + wt < dist[node]) {
                    dist[node] = pair.first + wt;
                    pq.offer(new Pair<>(pair.first + wt, node));
                }
            }
        }
        return dist;
    }
}
