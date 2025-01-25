class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 ) {
                    maxArea = Math.max(maxArea,
                            dfs(grid, i,j,row, col));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, int row, int col){
        if(r<0 || r>=row || c<0 || c>=col || grid[r][c] != 1){
            return 0;
        } else {
            grid[r][c] = 2;
            return 1 + dfs(grid, r+1, c, row, col)+
            dfs(grid, r-1, c, row, col)+
            dfs(grid, r, c+1, row, col)+
            dfs(grid, r, c-1, row, col);
        }
    }
}