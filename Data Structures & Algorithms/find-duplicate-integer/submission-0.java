class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int act = Math.abs(nums[i]);
            int index = act - 1;
            if(nums[index] < 0) return act;
            nums[index] = -1 * nums[index];
        }
        return -1;
    }
}
