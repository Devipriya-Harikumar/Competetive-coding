class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) {
            return image;
        }
        int row = image.length;
        int column = image[0].length;
        int source = image[sr][sc];
        dfs(image, sr, sc, color, row, column, source);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color, int row, int column, int source) {
        if(sr<0 || sr >= row|| sc<0 || sc >= column) {
            return;
        } else if(source != image[sr][sc]) {
            return;
        } 
        image[sr][sc] = color;
        dfs(image, sr+1, sc, color, row, column, source);
        dfs(image, sr-1, sc, color, row, column, source);
        dfs(image, sr, sc+1, color, row, column, source);
        dfs(image, sr, sc-1, color, row, column, source);
    }
}