package Graph;

import Utils.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1

public class MinimumMultiplicationToReachEnd {
    int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int dist[] = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        queue.offer(new Pair<>(start, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            for (int node : arr) {
                int newNode = (node * pair.first) % mod;
                if (pair.second + 1 < dist[newNode]) {
                    if (newNode == end) return pair.second + 1;
                    dist[newNode] = pair.second + 1;
                    queue.offer(new Pair<>(newNode, pair.second + 1));
                }
            }
        }
        return -1;
    }
}
