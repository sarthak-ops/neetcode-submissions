class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = heights.length-1;
        int area;
        while(i<j){
            area = (j-i) * Math.min(heights[i], heights[j]);
            if(area > max){
                max = area;
            }
            if(heights[i] > heights[j]){
                j--;
            }
            else {
                i++;
            }
        }
        return max;
    }
}
