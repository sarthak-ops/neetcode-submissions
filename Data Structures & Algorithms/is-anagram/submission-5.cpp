class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.length() != t.length()) return false;
        vector<int> al(26, 0);
        for(int i = 0; i < s.length(); ++i){
            char sc = s[i];
            char tc = t[i];
            al[sc-'a']++;
            al[tc-'a']--;
        }
        for(int i : al){
            if(i != 0) return false;
        }
        return true;
    }
};
