class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curs = 0;
        for(int n : nums){
            curs = Math.max(curs, 0);
            curs += n;
            max = Math.max(max, curs);
        }
        return max;
    }
}
