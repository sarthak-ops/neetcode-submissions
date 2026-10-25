class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int wat = 0;
        int rmax = 0;
        int lmax = 0;
        while(l < r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if(lmax < rmax){
                wat += lmax - height[l];
                l++;
            }
            else{
                wat += rmax - height[r];
                r--;
            }
        }
        return wat;
    }
}
