package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KahnsAlgo {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int res[] = new int[V];
        int inDegree[] = new int[V];
        for (ArrayList<Integer> arr : adj) {
            for (int val : arr) {
                inDegree[val]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        int pos = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[pos++] = node;
            for (int i : adj.get(node)) {
                inDegree[i]--;
                if (inDegree[i] == 0) queue.add(i);
            }
        }
        return res;
    }
}
