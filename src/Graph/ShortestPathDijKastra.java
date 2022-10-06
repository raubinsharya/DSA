package Graph;

import Utils.Pair;

import java.util.*;

// problem link
// https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-weighted-undirected-graph#_=_

public class ShortestPathDijKastra {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<Integer> res = new ArrayList<>();
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair<>(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair<>(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        int parent[] = new int[n + 1];
        int dist[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            dist[i] = 10000;
        }
        dist[1] = 0;
        pq.offer(new Pair<>(1, 0));
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int node = pair.first;
            int wt = pair.second;
            for (Pair<Integer, Integer> it : adj.get(node)) {
                if (wt + it.second < dist[it.first]) {
                    dist[it.first] = wt + it.second;
                    pq.offer(new Pair<>(it.first, dist[it.first]));
                    parent[it.first] = node;
                }
            }
        }
        if (dist[n] == 10000) {
            res.add(-1);
            return res;
        }
        int node = n;
        while (parent[node] != node) {
            res.add(node);
            node = parent[node];
        }
        res.add(1);
        Collections.reverse(res);
        return res;
    }
}
