package Recursion;

import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
public class RatInMaze {
    public static ArrayList<String> findPath(int[][] matrix, int n) {
        ArrayList<String> res = new ArrayList<>();
        boolean visited[][] = new boolean[n + 1][n + 1];
        solve(matrix, res, visited, "", n, 0, 0);
        return res;
    }

    private static void solve(int[][] matrix, ArrayList<String> res, boolean[][] visited, String temp, int n, int row, int col) {
        if (row == n - 1 && col == n - 1 && matrix[row][col] == 1) {
            res.add(temp);
            return;
        }
        if (matrix[row][col] == 0 || row >= n || col >= n || row < 0 || col < 0 || visited[row][col]) return;
        visited[row][col] = true;
        solve(matrix, res, visited, temp + "D", n, row + 1, col);
        solve(matrix, res, visited, temp + "R", n, row, col + 1);
        solve(matrix, res, visited, temp + "L", n, row, col - 1);
        solve(matrix, res, visited, temp + "U", n, row - 1, col);
        visited[row][col] = false;
    }
}
