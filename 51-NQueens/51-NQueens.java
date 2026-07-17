// Last updated: 7/17/2026, 3:05:00 PM
import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        boolean[] columns = new boolean[n];
        boolean[] leftDiagonal = new boolean[2 * n - 1];
        boolean[] rightDiagonal = new boolean[2 * n - 1];

        placeQueen(
            0,
            n,
            board,
            columns,
            leftDiagonal,
            rightDiagonal,
            result
        );

        return result;
    }

    private void placeQueen(
        int row,
        int n,
        char[][] board,
        boolean[] columns,
        boolean[] leftDiagonal,
        boolean[] rightDiagonal,
        List<List<String>> result
    ) {

        // All queens have been placed
        if (row == n) {
            result.add(createBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            int left = row - col + n - 1;
            int right = row + col;

            // Check whether this position is safe
            if (columns[col] ||
                leftDiagonal[left] ||
                rightDiagonal[right]) {
                continue;
            }

            // Place queen
            board[row][col] = 'Q';
            columns[col] = true;
            leftDiagonal[left] = true;
            rightDiagonal[right] = true;

            // Move to the next row
            placeQueen(
                row + 1,
                n,
                board,
                columns,
                leftDiagonal,
                rightDiagonal,
                result
            );

            // Backtrack and remove queen
            board[row][col] = '.';
            columns[col] = false;
            leftDiagonal[left] = false;
            rightDiagonal[right] = false;
        }
    }

    private List<String> createBoard(char[][] board) {
        List<String> currentBoard = new ArrayList<>();

        for (char[] row : board) {
            currentBoard.add(new String(row));
        }

        return currentBoard;
    }
}