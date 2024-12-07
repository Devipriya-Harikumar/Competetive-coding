class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i = 0; i<heights.length; i++){
            while(stack.peek() != -1 && heights[i]<=heights[stack.peek()]){
                int index = stack.pop();
                max = Math.max(max, heights[index]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            int index = stack.pop();
            max = Math.max(max, heights[index]*(heights.length - stack.peek() - 1));
        }
        return max;
    }
}