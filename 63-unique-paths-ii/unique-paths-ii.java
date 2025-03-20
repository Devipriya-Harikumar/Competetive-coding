class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] grid = new int[row][col];
        int i = 0;
        for (i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                grid[0][i] = 0;
                break;
            } else {
                grid[0][i] = 1;
            }
        }
        for(;i<col;i++){
            grid[0][i] = 0;
        }
        for (i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                grid[i][0] = 0;
                break;
            } else {
                grid[i][0] = 1;
            }
        }
         for(;i<row;i++){
            grid[i][0] = 0;
        }

        for(i = 1; i< row; i++) {
            for(int j = 1; j<col; j++){
                if(obstacleGrid[i][j] == 1){
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }

        return grid[row-1][col-1];
    }
}