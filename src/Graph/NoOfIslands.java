package Graph;

import java.util.LinkedList;
import java.util.Queue;
import Utils.Pair;

/*
 Problem Link
 https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find_the_number_of_islands
*/


public class NoOfIslands {
    public static int numIslands(char[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean visited[][] = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return res;
    }

    private static void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(row, col));
        int m = grid.length;
        int n = grid[0].length;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> temp = queue.poll();
            int ro = temp.first;
            int co = temp.second;
            int delRow[] = {-1, 0, 1, 0};
            int delCol[] = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int nRow = ro + delRow[i];
                int nCol = co + delCol[i];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == '1' && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    queue.offer(new Pair<>(nRow, nCol));
                }
            }
        }
    }

    public static void main(String[] args) {
        char arr[][] = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(arr));

    }
}


/*

[
["1","1","0","0","0"],
["1","1","0","0","0"],
["0","0","1","0","0"],
["0","0","0","1","1"]
]

*/