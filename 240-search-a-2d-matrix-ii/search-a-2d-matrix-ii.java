class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row =0;
        int n = matrix.length - 1;
        int col = matrix[0].length - 1;

        while (col>=0 && row <= n){
            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] > target) {
                col--;
            } else if(matrix[row][col] < target) {
                row++;
            }
        }
        return false;
    }
}