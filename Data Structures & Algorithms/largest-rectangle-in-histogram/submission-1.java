class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for(int i = 0; i <= heights.length; i++){
            int height = (i == heights.length) ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > height){
                int h = heights[stack.pop()];
                int w;
                if(stack.isEmpty()){
                    w = i;
                }
                else{
                    w = i - stack.peek() - 1;
                }
                max = Math.max(max, h * w);
            }
            if(i < heights.length){
                stack.push(i);
            }
        }
        return max;
    }
}
