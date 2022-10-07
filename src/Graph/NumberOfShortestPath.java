package Graph;

import Utils.Pair;

import java.util.*;

// Problem Link
// https://practice.geeksforgeeks.org/problems/number-of-ways-to-arrive-at-destination/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=/number-of-ways-to-arrive-at-destination
// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/submissions/817012060/
public class NumberOfShortestPath {
    static int countPaths(int n, List<List<Integer>> roads) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
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
    // leetcode
    public int countPaths(int n, int[][] roads) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] node : roads) {
            adj.get(node[0]).add(new Pair<>(node[1], node[2]));
            adj.get(node[1]).add(new Pair<>(node[0], node[2]));
        }
        long dist[] = new long[n];
        long ways[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair<Long, Long>> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.second));
        pq.offer(new Pair<>(0l, 0l));
        int mod = (int) (1e9 + 7);
        while (!pq.isEmpty()) {
            Pair<Long, Long> pairs = pq.poll();
            long node = pairs.first;
            long wt = pairs.second;
            for (Pair<Integer, Integer> it : adj.get((int) node)) {
                long newWt = wt + it.second;
                if (newWt < dist[it.first]) {
                    dist[it.first] = newWt;
                    pq.offer(new Pair<>(Long.valueOf(it.first), newWt));
                    ways[it.first] = ways[(int) node];
                } else if (newWt == dist[it.first]) {
                    ways[it.first] = (ways[(int) node] + ways[it.first]) % mod;
                }
            }
        }
        return (int) ways[n - 1];
    }
}

