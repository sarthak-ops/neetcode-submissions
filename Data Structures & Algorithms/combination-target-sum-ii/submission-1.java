class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        comb(candidates, 0, target, new ArrayList<>());
        return ans;
    }
    public void comb(int[] candidates, int i, int target, List<Integer> cur){
        if(target == 0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        if(i >= candidates.length){return;}
        if(target < 0){return;}
        for(int j = i; j < candidates.length; j++){
            if(j > i && candidates[j]==candidates[j-1]){
                continue;
            }
            cur.add(candidates[j]);
            comb(candidates, j+1, target-candidates[j], cur);
            cur.remove(cur.size()-1);
        }
    }
}
