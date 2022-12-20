package Recursion;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/word-break-ii/description/
public class WordBreakTwo {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        solve(s, wordDict, res, 0, "");
        return res;
    }

    private void solve(String str, List<String> wordDict, List<String> res, int idx, String temp) {
        if (idx == str.length()) res.add(temp.trim());
        for (int i = idx; i < str.length(); i++) {
            if (wordDict.contains(str.substring(idx, i + 1))) {
                solve(str, wordDict, res, i + 1, temp + str.substring(idx, i + 1) + " ");
            }
        }
    }
}
