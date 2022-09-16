package Graph;
// Problem Link
// Leetcode https://leetcode.com/problems/surrounded-regions/
// GFG https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=replace-os-with-xs

import Utils.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class ReplaceZeroWithX {
    // GFG
    // using BFS
    static char[][] fill(int m, int n, char grid[][]) {
        boolean visited[][] = new boolean[m][n];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        //  left
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 'O' && !visited[i][0]) {
                queue.offer(new Pair<>(i, 0));
                visited[i][0] = true;
            }
        }
        // right
        for (int i = 0; i < m; i++) {
            if (grid[i][n - 1] == 'O' && !visited[i][n - 1]) {
                queue.offer(new Pair<>(i, n - 1));
                visited[i][n - 1] = true;
            }
        }
        // top
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 'O' && !visited[0][i]) {
                queue.offer(new Pair<>(0, i));
                visited[0][i] = true;
            }
        }
        // bottom
        for (int i = 0; i < n; i++) {
            if (grid[m - 1][i] == 'O' && !visited[m - 1][i]) {
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
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 'O' && !visited[nRow][nCol]) {
                    queue.offer(new Pair<>(nRow, nCol));
                    visited[nRow][nCol] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'O' && !visited[i][j]) {
                    grid[i][j] = 'X';
                }
            }
        }
        return grid;
    }

    // leetcode
    public void solve(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        //  left
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 'O' && !visited[i][0]) {
                queue.offer(new Pair<>(i, 0));
                visited[i][0] = true;
            }
        }
        // right
        for (int i = 0; i < m; i++) {
            if (grid[i][n - 1] == 'O' && !visited[i][n - 1]) {
                queue.offer(new Pair<>(i, n - 1));
                visited[i][n - 1] = true;
            }
        }
        // top
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 'O' && !visited[0][i]) {
                queue.offer(new Pair<>(0, i));
                visited[0][i] = true;
            }
        }
        // bottom
        for (int i = 0; i < n; i++) {
            if (grid[m - 1][i] == 'O' && !visited[m - 1][i]) {
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
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 'O' && !visited[nRow][nCol]) {
                    queue.offer(new Pair<>(nRow, nCol));
                    visited[nRow][nCol] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'O' && !visited[i][j]) {
                    grid[i][j] = 'X';
                }
            }
        }
    }

}
