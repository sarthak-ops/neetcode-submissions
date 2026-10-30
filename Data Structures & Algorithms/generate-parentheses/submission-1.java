class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        gen(n, new StringBuilder(""), 0, 0);
        return ans;
    }
    public void gen(int n, StringBuilder cur, int o, int c){
        if(o == n && c == n){
            ans.add(cur.toString());
            return;
        }
        if(o < n){
            cur.append("(");
            gen(n, cur, o+1, c);
            cur.deleteCharAt(cur.length()-1);
        }
        if(c < o){
            cur.append(")");
            gen(n, cur, o, c+1);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
