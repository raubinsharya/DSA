package Graph;


import java.util.LinkedList;
import java.util.Queue;

import Utils.Pair;
import Utils.Pairs;

// Problem Link
// https://leetcode.com/problems/rotting-oranges/submissions/
// https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotten_oranges

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int countFresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        Queue<Pairs<Integer,Integer,Integer>> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pairs<>(i, j, 0));
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1) countFresh++;
            }
        }
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        int count = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            Pairs<Integer,Integer,Integer> temp = queue.poll();
            int row = temp.first;
            int col = temp.second;
            int t = temp.third;
            time = Math.max(t, time);
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    queue.offer(new Pairs<>(nRow, nCol, t + 1));
                    count++;
                }
            }
        }
        if (count != countFresh) return -1;
        return time;
    }
}
