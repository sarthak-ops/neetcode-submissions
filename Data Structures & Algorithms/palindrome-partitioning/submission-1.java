class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(0, s, new ArrayList<>());
        return ans;
    }
    public void backtrack(int index, String s, List<String> cur){
        if(index >= s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = index; i<s.length(); i++){
            String sub = s.substring(index, i+1);
            if(palindrome(sub)){
                cur.add(sub);
                backtrack(i+1, s, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    public boolean palindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<=r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
