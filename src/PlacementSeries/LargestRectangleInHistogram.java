package PlacementSeries;

import java.util.Stack;
// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        return solveTwoPass(heights);
    }

    private int solveTwoPass(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int leftPass[] = new int[n];
        int rightPass[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if (stack.isEmpty()) leftPass[i] = 0;
            else leftPass[i] = stack.peek() + 1;
            stack.push(i);
        }
        stack.clear();
        int maxi = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if (stack.isEmpty()) rightPass[i] = n - 1;
            else rightPass[i] = stack.peek() - 1;
            stack.push(i);
            maxi = Math.max(maxi, heights[i] * (rightPass[i] - leftPass[i] + 1));
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
