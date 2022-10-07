package Graph;

import Utils.Pair;

import java.util.*;

// Problem Link
// https://practice.geeksforgeeks.org/problems/number-of-ways-to-arrive-at-destination/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=/number-of-ways-to-arrive-at-destination

public class NumberOfShortestPath {
    static int countPaths(int n, List<List<Integer>> roads) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < roads.size(); i++) adj.add(new ArrayList<>());
        for (List<Integer> node : roads) {
            adj.get(node.get(0)).add(new Pair<>(node.get(1), node.get(2)));
            adj.get(node.get(1)).add(new Pair<>(node.get(0), node.get(2)));
        }
        int dist[] = new int[n];
        int ways[] = new int[n];
        Arrays.fill(dist, 100000);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        pq.offer(new Pair<>(0, 0));
        int mod = (int) (1e9 + 7);
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pairs = pq.poll();
            int node = pairs.first;
            int wt = pairs.second;
            for (Pair<Integer, Integer> it : adj.get(node)) {
                int newWt = wt + it.second;
                if (newWt < dist[it.first]) {
                    dist[it.first] = newWt;
                    pq.offer(new Pair<>(it.first, newWt));
                    ways[it.first] = ways[node];
                } else if (newWt == dist[it.first]) {
                    ways[it.first] = (ways[node] + ways[it.first]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}

