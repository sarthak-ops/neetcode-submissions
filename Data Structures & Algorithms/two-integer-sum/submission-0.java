class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> x = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (x.containsKey(diff)){
                int j = x.get(diff);
                return new int[]{Math.min(i, j), Math.max(i, j)};
            }
            x.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
