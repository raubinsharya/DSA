package Graph;

import Utils.Pair;

import java.util.*;

// Problem Link
// https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-distinct-islands

public class NumberOfDistinctIslands {
    public static int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<String> shape = new ArrayList<>();
                    dfs(grid, visited, shape, i, j, i, j, m, n);
                    // bfs(grid, visited, shape, i, j, m, n);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }

    private static void bfs(int[][] grid, boolean[][] visited, List<String> shape, int row, int col, int m, int n) {
        visited[row][col] = true;
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        queue.offer(new Pair<>(row, col));
        shape.add(toString(row - row, col - col));
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int ro = pair.first;
            int co = pair.second;
            for (int i = 0; i < 4; i++) {
                int nRow = ro + delRow[i];
                int nCol = co + delCol[i];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                    visited[nRow][nCol] = true;
                    queue.offer(new Pair<>(nRow, nCol));
                    shape.add(toString(row - nRow, col - nCol));
                }
            }

        }
    }

    private static void dfs(int[][] grid, boolean[][] visited, List<String> shape, int row, int col, int orRow, int orCol, int m, int n) {
        visited[row][col] = true;
        shape.add(toString(orRow - row, orCol - col));
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(grid, visited, shape, nRow, nCol, orRow, orCol, m, n);
            }
        }
    }

    private static String toString(int i, int j) {
        return String.valueOf(i + " " + j);
    }

    public static void main(String[] args) {
        int grid[][] = {
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 0, 0, 1, 1}
        };
        System.out.println(countDistinctIslands(grid));
    }
}
