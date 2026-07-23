class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums, int index, List<Integer> cur){
        if(index >= nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            cur.add(nums[i]);
            visited[i] = true;
            dfs(nums, index+1, cur);
            cur.remove(cur.size()-1);
            visited[i] = false;
        }
    }
}
