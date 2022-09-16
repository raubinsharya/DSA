package Graph;


import java.util.LinkedList;
import java.util.Queue;

import Utils.Pairs;

// problem Link
// https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-of-nearest-cell-having-1
// https://leetcode.com/problems/01-matrix/

//GFG problem
public class NearestCellHavingOne {
    public int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res[][] = new int[m][n];
        boolean visited[][] = new boolean[m][n];
        Queue<Pairs<Integer, Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Pairs<>(i, j, 0));
                    visited[i][j] = true;
                    res[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()) {
            Pairs<Integer, Integer, Integer> pair = queue.poll();
            int row = pair.first;
            int col = pair.second;
            int dist = pair.third;
            res[row][col] = dist;
            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 0 && !visited[nRow][nCol]) {
                    queue.add(new Pairs(nRow, nCol, dist + 1));
                    visited[nRow][nCol] = true;
                }
            }
        }
        return res;
    }
    // leetcode problem
    public int[][] updateMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res[][] = new int[m][n];
        boolean visited[][] = new boolean[m][n];
        Queue<Pairs<Integer, Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new Pairs(i, j, 0));
                    visited[i][j] = true;
                    res[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()) {
            Pairs<Integer, Integer, Integer> pair = queue.poll();
            int row = pair.first;
            int col = pair.second;
            int dist = pair.third;
            res[row][col] = dist;
            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                    queue.add(new Pairs(nRow, nCol, dist + 1));
                    visited[nRow][nCol] = true;
                }
            }
        }
        return res;
    }
}
