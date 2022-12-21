package Recursion;

// https://leetcode.com/problems/permutation-sequence/
public class KthPermutation {
    public static String getPermutation(int n, int k) {
        StringBuilder num = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            num.append(i);
            fact *= i;
        }
        solve(num, res, n, k - 1, fact);
        return res.toString();
    }

    private static void solve(StringBuilder num, StringBuilder res, int n, int k, int fact) {
        if (n <= 1) {
            res.append(num.charAt(0));
            return;
        }
        int part = fact / n;
        int pos = k / part;
        int remain = k % part;
        res.append(num.charAt(pos));
        num.deleteCharAt(pos);
        solve(num, res, n - 1, remain, part);
    }
}
