class Solution {
    public String longestPalindrome(String s) {
        String sb = "";
        int longest = 0;
        for(int i = 0; i < s.length(); i++){
            int l = i;
            int r = i;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > longest){
                    sb = s.substring(l, r+1);
                    longest = r-l+1;
                }
                l--;
                r++;
            }
            l = i;
            r = i+1;
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > longest){
                    sb = s.substring(l, r+1);
                    longest = r-l+1;
                }
                l--;
                r++;
            }
        }
        return sb;
    }
}
