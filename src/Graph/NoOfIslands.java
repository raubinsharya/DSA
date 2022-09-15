package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 Problem Link
 https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find_the_number_of_islands
*/

class Pair<R, C> {
    R row;
    C col;

    public Pair(R row, C col) {
        this.row = row;
        this.col = col;
    }
}

public class NoOfIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean visited[][] = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(row, col));
        int m = grid.length;
        int n = grid[0].length;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> temp = queue.poll();
            Integer ro = temp.row;
            int co = temp.col;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nRow = ro + i;
                    int nCol = co + j;
                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1' && !visited[nRow][nCol]) {
                        visited[nRow][nCol] = true;
                        queue.add(new Pair<>(nRow, nCol));
                    }
                }
            }
        }
    }
}
