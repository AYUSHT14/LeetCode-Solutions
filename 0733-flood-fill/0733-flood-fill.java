class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // Original color of starting pixel
        int originalColor = image[sr][sc];

        // If new color is same as original color
        // no need to do anything
        if (originalColor == color) {
            return image;
        }

        // Start DFS
        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    public void dfs(int[][] image, int row, int col,
                    int originalColor, int newColor) {

        // Boundary check
        if (row < 0 || col < 0 ||
            row >= image.length || col >= image[0].length) {
            return;
        }

        // Stop if color is different
        if (image[row][col] != originalColor) {
            return;
        }

        // Change color
        image[row][col] = newColor;

        // Visit all 4 directions
        dfs(image, row + 1, col, originalColor, newColor); // Down
        dfs(image, row - 1, col, originalColor, newColor); // Up
        dfs(image, row, col + 1, originalColor, newColor); // Right
        dfs(image, row, col - 1, originalColor, newColor); // Left
    }
}