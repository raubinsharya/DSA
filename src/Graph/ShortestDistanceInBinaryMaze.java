package Graph;

import Utils.Pairs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Problem Link
// https://practice.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-a-binary-maze

public class ShortestDistanceInBinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (source[0] == destination[0] && source[1] == destination[1]) return 0;
        int dist[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) Arrays.fill(dist[i], 10000);
        PriorityQueue<Pairs<Integer, Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.third));
        pq.offer(new Pairs<>(source[0], source[1], 0));
        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, 1, 0, -1};
        dist[source[0]][source[1]] = 0;
        while (!pq.isEmpty()) {
            Pairs<Integer, Integer, Integer> pair = pq.poll();
            int row = pair.first;
            int col = pair.second;
            int wt = pair.third;
            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == 1) {
                    if (wt + 1 < dist[nRow][nCol]) {
                        dist[nRow][nCol] = wt + 1;
                        pq.offer(new Pairs<>(nRow, nCol, wt + 1));
                    }
                }
            }
        }
        if (dist[destination[0]][destination[1]] == 10000) return -1;
        return dist[destination[0]][destination[1]];
    }
}
