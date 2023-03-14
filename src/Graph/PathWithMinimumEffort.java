package Graph;

import Utils.Pairs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    int MinimumEffort(int heights[][]) {
        int row = heights.length;
        int col = heights[0].length;
        PriorityQueue<Pairs<Integer, Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.third));
        int dist[][] = new int[row][col];
        for (int rows[] : dist) Arrays.fill(rows, Integer.MAX_VALUE);
        dist[0][0] = 0;
        pq.offer(new Pairs<>(0, 0, 0));
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        while (!pq.isEmpty()) {
            Pairs<Integer, Integer, Integer> pairs = pq.poll();
            int ro = pairs.first;
            int co = pairs.second;
            int diff = pairs.third;
            for (int i = 0; i < 4; i++) {
                int nRow = ro + delRow[i];
                int nCol = co + delCol[i];
                if (nRow >= 0 && nRow < row && nCol >= 0 && nCol < col) {
                    int effort = Math.max(Math.abs(heights[ro][co] - heights[nRow][nCol]), diff);
                    if (effort < dist[nRow][nCol]) {
                        dist[nRow][nCol] = effort;
                        pq.offer(new Pairs<>(nRow, nCol, effort));
                    }
                }
            }
        }
        return dist[row - 1][col - 1];
    }
}
