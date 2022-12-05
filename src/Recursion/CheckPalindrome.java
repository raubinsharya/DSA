package Recursion;
// https://leetcode.com/problems/valid-palindrome/description/
public class CheckPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray())
            if (Character.isLetterOrDigit(c)) sb.append(c);
        return solve(sb.toString().toCharArray(), 0, sb.length() - 1);
    }

    private boolean solve(char[] arr, int i, int j) {
        if (i >= j) return true;
        if (arr[i] != arr[j]) return false;
        return solve(arr, i + 1, j - 1);
    }
}
