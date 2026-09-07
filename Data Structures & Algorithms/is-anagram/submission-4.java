class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] al = new int[26];
        for(int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            al[sc - 'a']++;
            al[tc - 'a']--;
        }
        for(int i : al){
            if(i != 0) return false;
        }
        return true;
    }
}
