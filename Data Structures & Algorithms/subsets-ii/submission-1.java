class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, int index, List<Integer> cur){
        if(index >= nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        dfs(nums, index+1, cur);
        cur.remove(cur.size()-1);
        int next = index;
        while(next < nums.length-1 && nums[next] == nums[next+1]){
            next++;
        }
        dfs(nums, next+1, cur);
    }
}
