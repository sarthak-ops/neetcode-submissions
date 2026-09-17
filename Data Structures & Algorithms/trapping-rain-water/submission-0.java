class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;
        int water = 0;
        while(l < r){
            leftmax = Math.max(leftmax, height[l]);
            rightmax = Math.max(rightmax, height[r]);
            if(leftmax < rightmax){
                water += leftmax - height[l];
                l++;
            }
            else{
                water += rightmax - height[r];
                r--;
            }
        }
        return water;
    }
}
