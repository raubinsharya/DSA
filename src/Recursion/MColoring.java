package Recursion;

import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
public class MColoring {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int row = 0; row < graph.length; row++)
            for (int col = 0; col < graph[row].length; col++)
                if (graph[row][col])
                    adj.get(row).add(col);
        int color[] = new int[n];
        return solve(adj, color, m, n, 0);
    }

    private boolean solve(List<List<Integer>> adj, int[] color, int m, int n, int idx) {
        if (idx == n) return true;
        for (int i = 1; i <= m; i++) {
            if (isValid(adj, color, idx, i)) {
                color[idx] = i;
                if (solve(adj, color, m, n, idx + 1)) return true;
                color[idx] = 0;
            }
        }
        return false;
    }

    private boolean isValid(List<List<Integer>> adj, int[] colors, int idx, int color) {
        for (int node : adj.get(idx))
            if (colors[node] == color) return false;
        return true;
    }
}
