class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> visited = new HashSet<>();

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited.contains(r + "," + c)) {
                    islands++;
                    dfs(grid, r, c, visited, directions, rows, cols);
                }
            }
        }

        return islands;        
    }

     private void dfs(char[][] grid, int r, int c, Set<String> visited, int[][] directions, int rows, int cols) {
            visited.add(r + "," + c);
            for (int[] direction : directions) {
                int nr = r + direction[0], nc = c + direction[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1' && !visited.contains(nr + "," + nc)) {
                  dfs(grid, nr, nc, visited, directions, rows, cols);
                }
            }
    }
}