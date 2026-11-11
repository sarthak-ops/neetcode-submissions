class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int l = 0;
        int max = 0;
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            while(seen.contains(c)){
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(c);
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
