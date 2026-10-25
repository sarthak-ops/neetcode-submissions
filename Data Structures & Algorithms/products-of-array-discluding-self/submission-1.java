class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        int lacc = 1;
        for(int i = 1; i < nums.length; i++){
            lacc *= nums[i-1];
            left[i] = lacc;
        }
        int[] right = new int[nums.length];
        right[nums.length-1] = 1;
        int racc = 1;
        for(int i = right.length-2; i >=0; i--){
            racc *= nums[i+1];
            right[i] = racc;
        }
        int ans[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}  

// 1, 1, 2, 8
// 48, 24, 6, 1
