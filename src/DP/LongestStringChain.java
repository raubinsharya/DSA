package DP;

import java.util.Arrays;
import java.util.Comparator;
// https://leetcode.com/problems/longest-string-chain/description/

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int maxi = 0;
        int dp[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (checkString(words[i], words[j]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }

    private boolean checkString(String s1, String s2) {
        if (s1.length() != s2.length() + 1) return false;
        int i = 0;
        int j = 0;

        while (i < s1.length()) {
            if (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else i++;
        }

        if (i == s1.length() && j == s2.length()) return true;
        return false;
    }
}
