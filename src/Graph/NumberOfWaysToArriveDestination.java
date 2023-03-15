package Graph;

import Utils.Pair;

import java.util.*;


// https://practice.geeksforgeeks.org/problems/number-of-ways-to-arrive-at-destination/1

public class NumberOfWaysToArriveDestination {
    static int countPaths(int n, List<List<Integer>> roads) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> node : roads) {
            adj.get(node.get(0)).add(new Pair<>(node.get(1), node.get(2)));
            adj.get(node.get(1)).add(new Pair<>(node.get(0), node.get(2)));
        }
        long dist[] = new long[n];
        int ways[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair<Integer, Long>> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.second));
        pq.offer(new Pair<>(0, 0l));
        int mod = (int) (1e9 + 7);
        while (!pq.isEmpty()) {
            Pair<Integer, Long> pairs = pq.poll();
            int node = pairs.first;
            long wt = pairs.second;
            for (Pair<Integer, Integer> it : adj.get(node)) {
                long newWt = wt + it.second;
                if (newWt < dist[it.first]) {
                    dist[it.first] = newWt;
                    ways[it.first] = ways[node];
                    pq.offer(new Pair<>(it.first, newWt));
                } else if (newWt == dist[it.first]) {
                    ways[it.first] = (ways[node] + ways[it.first]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}
