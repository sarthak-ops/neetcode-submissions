class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        vector<int> ans(temperatures.size(), 0);
        stack<int> x;
        for(int i{0}; i < temperatures.size(); ++i){
            while(!(x.empty()) && temperatures[i] > temperatures[x.top()]){
                int temp{x.top()};
                x.pop();
                ans[temp] = i-temp;
            }
            x.push(i);
        }
        return ans;
    }
};
