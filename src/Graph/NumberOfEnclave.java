package Graph;

import Utils.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclave {
    int numberOfEnclaves(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];
        // vertical
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                queue.offer(new Pair<>(i, 0));
                visited[i][0] = true;
            }
            if (grid[i][n - 1] == 1 && !visited[i][n - 1]) {
                queue.offer(new Pair<>(i, n - 1));
                visited[i][n - 1] = true;
            }
        } // horizontal
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1 && !visited[0][i]) {
                queue.offer(new Pair<>(0, i));
                visited[0][i] = true;
            }
            if (grid[m - 1][i] == 1 && !visited[m - 1][i]) {
                queue.offer(new Pair<>(m - 1, i));
                visited[m - 1][i] = true;
            }
        }
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int row = pair.first;
            int col = pair.second;
            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                    queue.offer(new Pair<>(nRow, nCol));
                    visited[nRow][nCol] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) res++;
            }
        }
        return res;
    }
}
