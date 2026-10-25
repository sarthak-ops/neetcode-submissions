class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(int g : freq.keySet()){
            int f = freq.get(g);
            if(bucket[f] == null){
                bucket[f] = new ArrayList<>();
            }
            bucket[f].add(g);
        }
        int ind = 0;
        int[] ans = new int[k];
        for(int i = bucket.length-1; i >= 0 && ind < k; i--){
            if(bucket[i] != null){
                for(int r : bucket[i]){
                    ans[ind] = r;
                    ind++;
                    if(ind == k){
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
