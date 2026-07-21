class Solution {
    int trows;
    int tcols;
    char[][] board;
    String word;
    HashSet<Pair<Integer, Integer>> path = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        trows = board.length;
        tcols = board[0].length;
        this.board = board;
        this.word = word;
        for(int i = 0; i < trows; i++){
            for(int j = 0; j < tcols; j++){
                if(dfs(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, int i){
        if(i == word.length()){
            return true;
        }
        if(r < 0 || c < 0 || r >= trows || c >= tcols){
            return false;
        }

        Pair<Integer, Integer> pos = new Pair<>(r, c);
        
        if(word.charAt(i) != board[r][c]){
            return false;
        }
        if(path.contains(pos)){
            return false;
        }
        path.add(pos);
        boolean res = dfs(r+1, c, i+1) || dfs(r-1, c, i+1) || dfs(r, c+1, i+1) || dfs(r, c-1, i+1);
        path.remove(pos);
        return res;
    }
}
