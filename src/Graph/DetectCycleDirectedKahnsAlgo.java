package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// Problem Link
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph
public class DetectCycleDirectedKahnsAlgo {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int inDegree[] = new int[V];
        for (ArrayList<Integer> arr : adj) {
            for (int node : arr) {
                inDegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int it : adj.get(node)) {
                if (--inDegree[it] == 0) queue.add(it);
            }

        }
        if (count != V) return true;
        return false;
    }
}
