class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        
        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];

        for(int i = 0; i<col; i++){
            dfs(0, i, row, col, pac, heights[0][i], heights);
            dfs(row-1, i,row, col, atl, heights[row-1][i], heights);
        }
        for (int j = 0; j<row; j++){
            dfs(j, 0,row, col, pac, heights[j][0], heights);
            dfs(j, col-1,row, col, atl, heights[j][col-1], heights);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++){
                if (pac[i][j] && atl[i][j])
                    result.add(Arrays.asList(i,j));
            }
        return result;
    }

    private void dfs(int row, int col, int rowLength, int colLength, boolean[][] visited, int prevHeight, int[][] heights){
        if(row<0 || row>=rowLength || col<0 || col>=colLength || visited[row][col] || prevHeight > heights[row][col]) 
            return;
        
        visited[row][col] = true;
        dfs(row+1, col, rowLength, colLength, visited, heights[row][col], heights);
        dfs(row-1, col, rowLength, colLength, visited, heights[row][col], heights);
        dfs(row, col+1, rowLength, colLength, visited, heights[row][col], heights);
        dfs(row, col-1, rowLength, colLength, visited, heights[row][col], heights);
    }
}