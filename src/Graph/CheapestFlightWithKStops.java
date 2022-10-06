package Graph;

import Utils.Pair;
import Utils.Pairs;

import java.util.*;

// Problem Link
// https://practice.geeksforgeeks.org/problems/cheapest-flights-within-k-stops/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=cheapest-flights-within-k-stops

public class CheapestFlightWithKStops {
    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            adj.get(flights[i][0]).add(new Pair<>(flights[i][1], flights[i][2]));
        }
        PriorityQueue<Pairs<Integer, Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.third));
        int dist[] = new int[n];
        Arrays.fill(dist, 10000);
        dist[src] = 0;
        pq.offer(new Pairs<>(src, 0, 0));
        while (!pq.isEmpty()) {
            Pairs<Integer, Integer, Integer> pairs = pq.poll();
            int node = pairs.first;
            int wt = pairs.second;
            int stop = pairs.third;
            for (Pair<Integer, Integer> it : adj.get(node)) {
                int newDist = wt + it.second;
                int newStop = stop;
                if (it.first != dst) newStop++;
                if (newDist < dist[it.first] && newStop <= k) {
                    dist[it.first] = newDist;
                    pq.offer(new Pairs<>(it.first, newDist, newStop));
                }
            }
        }
        if (dist[dst] == 10000) return -1;
        return dist[dst];
    }
}
