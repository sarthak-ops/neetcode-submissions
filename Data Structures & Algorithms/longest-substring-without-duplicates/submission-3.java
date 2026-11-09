class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int max = 0;
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            if(set.contains(c)){
                while(set.contains(c)){
                    char lef = s.charAt(l);
                    set.remove(lef);
                    l++;
                }
            }
            set.add(c);
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
