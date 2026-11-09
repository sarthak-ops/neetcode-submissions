class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = 0;
        for(int n : nums){
            cur = Math.max(cur, 0);
            cur += n;
            max = Math.max(max, cur);
        }
        return max;
    }
}
