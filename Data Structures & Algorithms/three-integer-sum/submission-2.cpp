class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> x;
        for(int i{0}; i < nums.size()-2; ++i){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int k{i+1}, j{static_cast<int>(nums.size())-1};
            while(k < j){
                int sum{nums[j] + nums[k]};
                if(sum > -nums[i]){
                    j--;
                }
                else if(sum < -nums[i]){
                    k++;
                }
                else{
                    x.push_back({nums[i], nums[k], nums[j]});
                    j--;
                    k++;
                    while(k < j && nums[k] == nums[k-1]){
                        k++;
                    }
                    while(k < j && nums[j] == nums[j+1]){
                        j--;
                    }
                }
            }
        }
        return x;
    }
};
