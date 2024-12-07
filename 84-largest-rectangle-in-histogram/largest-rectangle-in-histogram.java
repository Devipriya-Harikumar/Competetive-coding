class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Height> stack = new Stack<>();

        for(int i = 0; i<heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && (heights[i]<=stack.peek().height)){
                Height height = stack.pop();
                max = Math.max(max, height.height*(i-height.index));
                start = height.index;
            }
            Height h = new Height();
            h.index = start;
            h.height = heights[i];
            stack.push(h);
        }
        while(!stack.isEmpty()){
            Height h = stack.pop();
            max = Math.max(max, h.height*(heights.length - h.index));
        }
        return max;
    }

    public class Height {
        private int index;
        private int height;
    }
}