package Graph;

import java.util.*;

// Problem Link
// https://leetcode.com/problems/find-eventual-safe-states/
// https://practice.geeksforgeeks.org/problems/eventual-safe-states/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=eventual-safe-states


public class SafeStateBFS {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<List<Integer>> revAdj = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        int inDeg[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int node : adj.get(i)) {
                revAdj.get(node).add(i);
                inDeg[i]++;
            }
        }
        for (int i = 0; i < V; i++) if (inDeg[i] == 0) queue.offer(i);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (int i : revAdj.get(node)) {
                if (--inDeg[i] == 0) queue.offer(i);
            }
        }
        Collections.sort(res);
        return res;
    }

    // Leetcode
    public List<Integer> eventualSafeNodes(int[][] adj) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> revAdj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int v = adj.length;
        for (int i = 0; i < v; i++) {
            revAdj.add(new ArrayList<>());
        }
        int inDeg[] = new int[v];
        for (int i = 0; i < v; i++) {
            for (int node : adj[i]) {
                revAdj.get(node).add(i);
                inDeg[i]++;
            }
        }
        for (int i = 0; i < v; i++) if (inDeg[i] == 0) queue.offer(i);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (int i : revAdj.get(node)) if (--inDeg[i] == 0) queue.offer(i);
        }
        Collections.sort(res);
        return res;
    }
}
