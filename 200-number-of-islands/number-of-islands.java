class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> visited = new HashSet<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited.contains(r + "," + c)) {
                    islands++;
                    dfs(grid, r, c, visited, rows, cols);
                }
            }
        }

        return islands;        
    }

     private void dfs(char[][] grid, int r, int c, Set<String> visited, int rows, int cols) {
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == '1' && !visited.contains(r + "," + c)) {
                    visited.add(r + "," + c);
                  dfs(grid, r+1, c, visited, rows, cols);
                  dfs(grid, r-1, c, visited, rows, cols);
                  dfs(grid, r, c+1, visited, rows, cols);
                  dfs(grid, r, c-1, visited, rows, cols);
            }
    }
}