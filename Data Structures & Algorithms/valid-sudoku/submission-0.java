class Solution {
    char[][] board;
    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        for(int i = 0; i < board.length; i++){
            if(validr(board[i])==false){
                return false;
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            char[] col = new char[board.length];
            for (int i = 0; i < board.length; i++) {
                col[i] = board[i][j];
            }
            if (!validc(col)) return false;
        }
        for(int i = 0; i < board.length; i+=3){
            for(int j = 0; j < board[0].length; j+=3){
                if(!valid3(i, j)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean valid3(int r, int c){
        HashSet<Character> seen = new HashSet<>();
        for(int i = r; i < r+3; i++){
            for(int j = c; j < c+3; j++){
                if(board[i][j]!='.' && seen.contains(board[i][j])){
                    return false;
                }
                if(board[i][j]!='.'){
                    seen.add(board[i][j]);
                }
            }
        }
        return true;
    }
    public boolean validc(char[] board){
        HashSet<Character> seen = new HashSet<>(); 
        for(int i = 0; i < board.length; i++){
            if(!seen.isEmpty() && seen.contains(board[i])){
                return false;
            }
            if(board[i] != '.'){
                seen.add(board[i]);
            }
        }
        return true;
    }
    public boolean validr(char[] board){
        HashSet<Character> seen = new HashSet<>(); 
        for(int i = 0; i < board.length; i++){
            if(!seen.isEmpty() && seen.contains(board[i])){
                return false;
            }
            if(board[i] != '.'){
                seen.add(board[i]);
            }
        }
        return true;
    }
}
