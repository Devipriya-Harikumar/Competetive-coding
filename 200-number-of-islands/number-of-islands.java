class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    dfs(grid, r, c, rows, cols);
                }
            }
        }

        return islands;        
    }

     private void dfs(char[][] grid, int r, int c, int rows, int cols) {
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == '1') {
                    grid[r][c] = '2';
                  dfs(grid, r+1, c, rows, cols);
                  dfs(grid, r-1, c, rows, cols);
                  dfs(grid, r, c+1, rows, cols);
                  dfs(grid, r, c-1, rows, cols);
            }
    }
}