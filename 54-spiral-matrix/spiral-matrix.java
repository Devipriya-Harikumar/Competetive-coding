class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
          List<Integer> res = new ArrayList<>();
        int top=0, bottom = matrix.length;
        int left =0, right = matrix[0].length;
        int i;
        while(left<right && top<bottom){
            for(i=left;i<right;i++){
                res.add(matrix[top][i]);
            }
            top+=1;
             for(i=top;i<bottom;i++){
                res.add(matrix[i][right-1]);
            }
            right-=1;
            if(!(left<right && top<bottom)){
                break;
            }
             for(i=right-1;i>left-1;i--){
                res.add(matrix[bottom-1][i]);
            }
            bottom-=1;
            for(i=bottom-1;i>top-1;i--){
                res.add(matrix[i][left]);
            }
            left+=1;
        }
        return res;
    }
}