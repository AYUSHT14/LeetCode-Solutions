class Solution {

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // Step 1:
        // Mark all boundary connected 'O' as '#'

        // First column and last column
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }

        // Top row and bottom row
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }

        // Step 2:
        // Convert remaining 'O' into 'X'
        // Convert '#' back to 'O'

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                // Surrounded region
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                // Safe region
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {

        // Boundary check
        if (row < 0 || col < 0 ||
            row >= board.length ||
            col >= board[0].length ||
            board[row][col] != 'O') {

            return;
        }

        // Mark safe cell
        board[row][col] = '#';

        // Visit all 4 directions

        dfs(board, row + 1, col); // Down
        dfs(board, row - 1, col); // Up
        dfs(board, row, col + 1); // Right
        dfs(board, row, col - 1); // Left
    }
}