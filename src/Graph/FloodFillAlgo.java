package Graph;

public class FloodFillAlgo {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] copyImg = image;
        int initialColor = image[sr][sc];
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        dfs(image, copyImg, sr, sc, initialColor, newColor, delRow, delCol);
        return copyImg;
    }

    private void dfs(int[][] image, int[][] copyImg, int row, int col, int initialColor, int newColor, int[] delRow, int[] delCol) {
        image[row][col] = newColor;
        int m = image.length;
        int n = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && image[nRow][nCol] == initialColor && copyImg[nRow][nCol] != newColor) {
                dfs(image, copyImg, nRow, nCol, initialColor, newColor, delRow, delCol);
            }
        }

    }
}
