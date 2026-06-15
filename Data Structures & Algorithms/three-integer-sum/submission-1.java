class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> x = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[j] + nums[k];
                if(sum < -nums[i]){
                    j++;
                }
                else if(sum > -nums[i]){
                    k--;
                }
                else{
                    x.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return x;
    }
}
