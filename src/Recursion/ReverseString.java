package Recursion;

public class ReverseString {
    public void reverseString(char[] s) {
        solve(s, 0, s.length - 1);
    }

    private void solve(char[] s, int i, int j) {
        if (i == j) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        solve(s, i + 1, j - 1);
    }
}
