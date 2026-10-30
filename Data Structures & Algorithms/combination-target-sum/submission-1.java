class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        btrack(nums, 0, target, new ArrayList<>());
        return ans;
    }
    public void btrack(int[] nums, int i, int r, List<Integer> cur){
        if(r==0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        if(r<0){return;}
        for(int l = i; l < nums.length; l++){
            cur.add(nums[l]);
            btrack(nums, l, r-nums[l], cur);
            cur.remove(cur.size()-1);
        }
    }
}
