class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, new StringBuilder(""), 0, 0);
        return ans;
    }
    public void backtrack(int number, StringBuilder cur, int open, int close){
        if(open == number && close == number){
            ans.add(cur.toString());
            return;
        }
        if(open < number){
            cur.append("(");
            backtrack(number, cur, open+1, close);
            cur.deleteCharAt(cur.length()-1);
        }
        if(close < open){
            cur.append(")");
            backtrack(number, cur, open, close+1);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
