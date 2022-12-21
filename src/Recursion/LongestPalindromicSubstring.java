package Recursion;

public class LongestPalindromicSubstring {
    String result = "";

    public String longestPalindrome(String s) {
        solve(s, 0);
        return result;
    }

    private void solve(String str, int idx) {
        if (idx == str.length()) return;
        for (int i = idx; i < str.length(); i++) {
            String temp = str.substring(idx, i + 1);
            if (new StringBuilder(temp).reverse().toString().equals(temp) && temp.length() >= result.length()) {
                this.result = temp;
                solve(str, i + 1);
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
