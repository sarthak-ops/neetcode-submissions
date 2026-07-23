class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>());
        return ans;
    }
    public void dfs(int[] candidates, int index, int target, ArrayList<Integer> cur){
        if(target == 0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }  
            cur.add(candidates[i]);
            dfs(candidates, i+1, target - candidates[i], cur);
            cur.remove(cur.size()-1);
        }
    }
}
