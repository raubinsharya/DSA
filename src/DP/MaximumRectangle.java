package DP;

import java.util.Stack;
// https://leetcode.com/problems/maximal-rectangle/description/
public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        int heights[] = new int[matrix.length];
        int maxi = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            int area = solveSinglePass(heights);
            maxi = Math.max(maxi, area);
        }
        return maxi;
    }

    public int solveSinglePass(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                int num = heights[stack.pop()];
                int width = 0;
                if (stack.isEmpty()) width = i;
                else width = i - stack.peek() - 1;
                maxi = Math.max(maxi, width * num);
            }
            stack.push(i);
        }
        return maxi;
    }
}
