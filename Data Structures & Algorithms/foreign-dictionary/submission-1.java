class Solution {
    HashMap<Character, HashSet<Character>> list;
    HashSet<Character> visited;
    HashSet<Character> visiting;
    StringBuilder sb;
    public String foreignDictionary(String[] words) {
        visited = new HashSet<>();
        visiting = new HashSet<>();
        list = new HashMap<>();
        sb = new StringBuilder();
        for(String w : words){
            for (int j = 0; j < w.length(); j++) {
                char c = w.charAt(j);
                list.put(c, new HashSet<>());
            }
        }
        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int minlen = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() && w1.startsWith(w2)){
                return "";
            }
            for(int j = 0; j < minlen; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    list.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        for(Character c : list.keySet()){
            if(!dfs(c)) return "";
        }
        return sb.reverse().toString();
    }
    public boolean dfs(Character c){
        if(visiting.contains(c)) return false;
        if(visited.contains(c)) return true;
        visiting.add(c);
        for(char nei : list.get(c)){
            if(!dfs(nei)) return false;
        }
        visiting.remove(c);
        visited.add(c);
        sb.append(c);
        return true;
    } 
}
