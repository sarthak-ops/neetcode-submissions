class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> x;
        for(int i = 0; i < nums.size(); i++){
            int req = target - nums[i];
            if(x.contains(req)){
                return {x[req], i};
            }
            x[nums[i]] = i;
        }
        return {-1, -1};
    }
};
