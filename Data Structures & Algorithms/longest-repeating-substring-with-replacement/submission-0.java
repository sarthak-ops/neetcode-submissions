class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> x = new HashMap<>();
        int m = 0;
        int maxfreq = 0;
        int windowsize = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            windowsize = i-m+1;
            char c = s.charAt(i);
            x.put(c, x.getOrDefault(c, 0) + 1);
            maxfreq = Math.max(maxfreq, x.get(c));
            if(windowsize - maxfreq > k){
                x.put(s.charAt(m), x.get(s.charAt(m))-1);
                if(x.get(s.charAt(m)) == 0){
                    x.remove(s.charAt(m));
                }
                m++;
            }
            ans = Math.max(ans, i - m + 1);
        }
        return ans;
    }
}
