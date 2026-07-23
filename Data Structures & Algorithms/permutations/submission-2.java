class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums, List<Integer> cur){
        if(cur.size() >= nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            cur.add(nums[i]);
            visited[i] = true;
            dfs(nums, cur);
            cur.remove(cur.size()-1);
            visited[i] = false;
        }
    }
}
