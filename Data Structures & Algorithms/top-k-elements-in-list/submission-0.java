class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> x = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            x.put(nums[i], x.getOrDefault(nums[i], 0) +1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(int key : x.keySet()){
            int freq = x.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int index = 0;
        int[] ans = new int[k];
        for(int i = bucket.length-1; i >= 0 && index < k; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    ans[index] = num;
                    index++;
                    if(index == k){
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
