class WordDictionary {

    class TrieNode{
        TrieNode[] children;
        boolean endOfWord;

        public TrieNode(){
            children = new TrieNode[26];
            endOfWord = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                return dfs(node, word, i);
            }
            if(node.children[c-'a'] == null){
                return false;
            }
            node = node.children[c-'a'];
        }
        return node.endOfWord;
    }

    public boolean dfs(TrieNode node, String word, int index){
        if(index == word.length()){
            return node.endOfWord;
        }
        if(word.charAt(index) != '.'){
            if(node.children[word.charAt(index)-'a']==null){
                return false;
            }
            node = node.children[word.charAt(index)-'a'];
            return dfs(node, word, index+1);
        }
        else{
            for(int i = 0; i < node.children.length; i++){
                if(node.children[i] != null){
                    if(dfs(node.children[i], word, index+1) == true){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
