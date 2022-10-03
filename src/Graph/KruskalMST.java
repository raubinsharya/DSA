package Graph;

import Utils.Pairs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// problem link
// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

public class KruskalMST {

    static int rank[] = new int[1001];
    static int parent[] = new int[1001];

    static int find(int Parent[], int X) {
        if (Parent[X] == X) return X;
        return Parent[X] = find(Parent, Parent[X]);
    }

    static void unionSet(int Parent[], int X, int Z) {
        X = find(Parent, X);
        Z = find(Parent, Z);
        if (rank[X] < rank[Z]) {
            Parent[X] = Z;
        } else if (rank[Z] < rank[X]) {
            Parent[Z] = X;
        } else {
            Parent[Z] = X;
            rank[X]++;
        }
    }

    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int sum = 0;
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }
        PriorityQueue<Pairs<Integer, Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.third));
        for (int i = 0; i < V; i++) {
            for (ArrayList<Integer> list : adj.get(i)) {
                pq.offer(new Pairs<>(i, list.get(0), list.get(1)));
            }
        }
        while (!pq.isEmpty()) {
            Pairs<Integer, Integer, Integer> pairs = pq.poll();
            if (find(parent, pairs.first) != find(parent, pairs.second)) {
                sum += pairs.third;
                unionSet(parent, pairs.first, pairs.second);
            }

        }
        return sum;
    }
}

