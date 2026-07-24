class Solution {
    HashMap<Character, String> map;
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return ans;
        }
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, 0, new StringBuilder(""));
        return ans;
    }
    public void backtrack(String digits, int index, StringBuilder cur){
        if(cur.length() == digits.length()){
            ans.add(cur.toString());
            return;
        }
        String n = map.get(digits.charAt(index));
        for(int i = 0; i < n.length(); i++){
            char c = n.charAt(i);
            cur.append(c);
            backtrack(digits, index+1, cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
