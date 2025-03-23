class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int rows = matrix.length,
			cols = matrix[0].length,
            row = 0, col = cols - 1;
			
        while (row < rows && col > -1) {
            int cur = matrix[row][col];
            if (cur == target) return true;
            if (target > cur) row++;
            else col--;
        }
        
        return false;
    }
}