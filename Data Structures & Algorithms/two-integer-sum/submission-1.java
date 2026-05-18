class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> x = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int req = target - nums[i];
            if(x.containsKey(req)){
                return new int[]{x.get(req), i};
            }
            x.put(nums[i], i);
        }
        return new int[]{};
    }
}
