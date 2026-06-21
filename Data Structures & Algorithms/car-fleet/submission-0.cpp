class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        int m = position.size();
        vector<pair<int, int>> x;
        stack<double> ans;
        for(int i{0}; i < position.size(); ++i){
            x.push_back({position[i], speed[i]});
        }
        sort(x.begin(), x.end());
        for(int i = m-1; i >= 0; i--){
            double time = (double)(target - x[i].first) / x[i].second;
            if(ans.empty() || time > ans.top()){
                ans.push(time);
            }
        }
        return ans.size();
    }
};
