package Recursion;
// https://leetcode.com/problems/fibonacci-number/description/
public class FibonacciSeries {

    public int fib(int n) {
        return solveTopDown(n);
    }

    private int solveTopDown(int n) {
        if (n == 1) return 1;
        if (n < 1) return 0;
        return solveTopDown(n - 1) + solveTopDown(n - 2);
    }
}
