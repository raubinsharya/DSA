package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// https://leetcode.com/problems/palindrome-partitioning/description/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> temp = new LinkedList<>();
        solve(res, temp, s, 0);
        return res;
    }

    private void solve(List<List<String>> res, LinkedList<String> temp, String s, int idx) {
        if (idx == s.length()) res.add(new ArrayList<>(temp));
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                temp.add(s.substring(idx, i + 1));
                solve(res, temp, s, i + 1);
                temp.removeLast();
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
}
