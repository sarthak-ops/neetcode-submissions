class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    HashSet<Integer> seen = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums, int index, List<Integer> cur){
        if(index >= nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(seen.contains(nums[i])){
                continue;
            }
            cur.add(nums[i]);
            seen.add(nums[i]);
            dfs(nums, index+1, cur);
            cur.remove(cur.size()-1);
            seen.remove(nums[i]);
        }
    }
}
