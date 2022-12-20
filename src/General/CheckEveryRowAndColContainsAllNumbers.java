package General;

import java.util.HashSet;
import java.util.Set;
// https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/description/
public class CheckEveryRowAndColContainsAllNumbers {
    public boolean checkValid(int[][] matrix) {
        return solve(matrix);
    }

    private boolean solve(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();
            for (int col = 0; col < n; col++) {
                if (!rows.add(matrix[row][col])) return false;
                if (!cols.add(matrix[col][row])) return false;
            }
        }
        return true;
    }
}
