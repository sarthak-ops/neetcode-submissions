class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> x = new HashSet<>();
        int m = 0;
        int l = 0;
        for(int i = 0; i < s.length(); i++){
            while(x.contains(s.charAt(i))){
                x.remove(s.charAt(l));
                l++;
            }
            m = Math.max(m, i-l+1);
            x.add(s.charAt(i));
        }
        return m;
    }
}
