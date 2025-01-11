class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>(); // r+c
    Set<Integer> negDiag = new HashSet<>(); // r-c

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, board, result, n);
        return result;
    }

    private void backtrack(int row, char[][] board, List<List<String>> result, int n) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] i : board) {
                solution.add(new String(i));
            }
            result.add(solution);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || posDiag.contains(row + c) || negDiag.contains(row - c)) {
                continue;
            }

            col.add(c);
            posDiag.add(row + c);
            negDiag.add(row - c);
            board[row][c] = 'Q';

            backtrack(row + 1, board, result, n);

            col.remove(c);
            posDiag.remove(row + c);
            negDiag.remove(row - c);
            board[row][c] = '.';
        }

    }
}