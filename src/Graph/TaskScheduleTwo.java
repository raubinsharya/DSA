package Graph;

import java.util.*;

// Problem Link
// https://leetcode.com/problems/course-schedule-ii/submissions/
//
public class TaskScheduleTwo {
    // leetcode
    public int[] findOrder(int V, int[][] prerequisites) {
        int row = prerequisites.length;
        List<List<Integer>> adj = new ArrayList<>();
        int topo[] = new int[V];
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < row; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int inDegree[] = new int[V];
        for (List<Integer> i : adj) {
            for (int node : i) {
                inDegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo[index++] = node;
            for (int i : adj.get(node)) {
                if (--inDegree[i] == 0) queue.add(i);
            }
        }
        if (index == V) return topo;
        return new int[0];
    }
    // GFG
    static int[] findOrder(int V, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        int order[] = new int[V];
        List<List<Integer>> adj = new ArrayList<>(V);
        Collections.fill(adj, new ArrayList<>());
        Queue<Integer> queue = new LinkedList<>();
        int inDeg[] = new int[V];
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }
        for (List<Integer> i : adj) {
            for (int node : i) inDeg[node]++;
        }
        for (int i = 0; i < V; i++) if (inDeg[i] == 0) queue.offer(i);
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;
            for (int i : adj.get(node)) if (--inDeg[i] == 0) queue.offer(i);
        }
        if (index == V) return order;
        return new int[0];
    }
}
