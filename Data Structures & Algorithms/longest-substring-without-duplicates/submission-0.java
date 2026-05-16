class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> x = new HashSet<>();
        int left = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            while(x.contains(s.charAt(i))){
                x.remove(s.charAt(left));
                left++;
            }
            x.add(s.charAt(i));
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}
