class Solution {
    List<List<Integer>> answers = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, target, new ArrayList<>());
        return answers;
    }
    public void dfs(int[] nums, int index, int remaining, List<Integer> cur){
        if(remaining == 0){
            answers.add(new ArrayList<>(cur));
            return;
        }
        if(remaining < 0){
            return;
        }
        for(int i = index; i < nums.length; i++){
            cur.add(nums[i]);
            dfs(nums, i, remaining-nums[i], cur);
            cur.remove(cur.size()-1);
        }
    }
}
