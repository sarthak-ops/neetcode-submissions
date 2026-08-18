class Solution {
    public String minWindow(String s, String t) {
        if (s == null) {
            return "";
        }
        if (t == null) {
            return s;
        }
        int slen = s.length();
        int tlen = t.length();
        if (slen < tlen) {
            return "";
        }
        String ans = "";
        HashMap<Character, Integer> want = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            want.put(c, want.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        int r = 0;
        int have = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            if(want.containsKey(c)){
                if(want.get(c) > 0){
                    have++;
                }
                want.put(c, want.get(c)-1);
            }
            r++;
            while(have == t.length()){
                String cur = s.substring(l, r);
                if(ans.isEmpty() || cur.length() < ans.length()){
                    ans = cur;
                }
                char c2 = s.charAt(l);
                if(want.containsKey(c2)){
                    want.put(c2, want.get(c2)+1);
                    if(want.get(c2) > 0){
                        have--;
                    }
                }
                l++;
            }
        }
        return ans;
    }
}
