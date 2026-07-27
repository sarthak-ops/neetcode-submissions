class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            int k = i;
            int l = i;
            while(k >= 0 && l < s.length() && s.charAt(k) == s.charAt(l)){
                count++;
                l++;
                k--;
            }
            k = i;
            l = i + 1;
            while(k >= 0 && l < s.length() && s.charAt(k) == s.charAt(l)){
                count++;
                l++;
                k--;
            }
        }
        return count;
    }
}
