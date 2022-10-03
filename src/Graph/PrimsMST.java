package Graph;

import Utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

public class PrimsMST {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int sum = 0;
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        int mst[] = new int[V];
        boolean visited[] = new boolean[V];
        Arrays.fill(mst, Integer.MAX_VALUE);
        pq.offer(new ArrayList<>());
        pq.peek().add(0);
        pq.peek().add(0);
        while (!pq.isEmpty()) {
            ArrayList<Integer> pair = pq.poll();
            if (mst[pair.get(0)] > pair.get(1) || !visited[pair.get(0)]) {
                mst[pair.get(0)] = pair.get(1);
                sum += pair.get(1);
                visited[pair.get(0)] = true;
            } else continue;
            for (ArrayList<Integer> node : adj.get(pair.get(0))) {
                if (!visited[node.get(0)]) {
                    pq.offer(node);
                }
            }
        }
        return sum;
    }
}
