package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        if (adj == null || adj.size() == 0) return res;
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V + 1];
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (int i : adj.get(node)) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return res;
    }
}
