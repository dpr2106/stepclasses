import java.util.*;

public class NQueensSolver {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();

        backtrack(0, n, board, cols, diag1, diag2, solutions);
        return solutions;
    }

    private static void backtrack(int r, int n, char[][] board, Set<Integer> cols, Set<Integer> d1, Set<Integer> d2, List<List<String>> res) {
        if (r == n) {
            List<String> valid = new ArrayList<>();
            for (char[] row : board) valid.add(new String(row));
            res.add(valid);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || d1.contains(r - c) || d2.contains(r + c)) continue;

            board[r][c] = 'Q';
            cols.add(c);
            d1.add(r - c);
            d2.add(r + c);

            backtrack(r + 1, n, board, cols, d1, d2, res);

            board[r][c] = '.';
            cols.remove(c);
            d1.remove(r - c);
            d2.remove(r + c);
        }
    }

    public static void main(String[] args) {
        List<List<String>> sol = solveNQueens(4);
        System.out.println("Solutions for 4-Queens: " + sol.size());
    }
}
