class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> con = new HashSet<>();
        int max = 0;
        int s;
        for(int x : nums){
            con.add(x);
        }
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            s = 1;
            if(!con.contains(cur-1)){
                while(con.contains(cur+1)){
                    s++;
                    cur++;
                }
            }
            max = Math.max(max, s);
        }
        return max;
    }
}
