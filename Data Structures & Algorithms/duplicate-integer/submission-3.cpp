class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        std::unordered_set<int> x;
        for(int i(0); i < nums.size(); i++){
            if(x.contains(nums[i])){
                return true;
            }
            x.insert(nums[i]);
        }
        return false;
    }
};