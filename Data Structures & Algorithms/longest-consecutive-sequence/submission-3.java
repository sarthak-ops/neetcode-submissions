class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){set.add(i);}
        int longest = 0;
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(!set.contains(cur-1)){
                int l = 1;
                while(set.contains(cur+1)){
                    l++;
                    cur++;
                }
                longest = Math.max(longest, l);
            }
        }
        return longest;
    }
}
