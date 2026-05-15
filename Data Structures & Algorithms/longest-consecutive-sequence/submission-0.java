class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> x = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            x.add(nums[i]);
        }
        int max = 0;
        for(int num : x){
            if(!(x.contains(num-1))){
                int curr = num;
                int length = 1;
                while(x.contains(curr+1)){
                    curr++;
                    length++;
                }
                max = Math.max(max, length);
            }
        }
        return max;
    }
}
