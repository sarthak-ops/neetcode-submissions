class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int maxend = nums[0];
        int minend = nums[0];
        for(int i = 1; i < nums.length; i++){
            int prevmax = maxend;
            int prevmin = minend;

            maxend = Math.max(nums[i], Math.max(prevmax * nums[i], prevmin * nums[i]));
            minend = Math.min(nums[i], Math.min(prevmax * nums[i], prevmin * nums[i]));

            ans = Math.max(ans, maxend);
        }
        return ans;
    }
}
