class Solution {
    char[][] board;
    boolean[][] bbo;
    int r;
    int c;
    public void solve(char[][] board) {
        this.board = board;
        this.r = board.length;
        this.c = board[0].length;
        this.bbo = new boolean[board.length][board[0].length];
        for(int i = 0; i < c; i++){
            dfs(0, i);
        }
        for(int i = 0; i < r; i++){
            dfs(i, 0);
        }
        for(int i = 0; i < c; i++){
            dfs(board.length-1, i);
        }
        for(int i = 0; i < r; i++){
            dfs(i, board[0].length-1);
        }
        for(int i = 1; i < board.length-1; i++){
            for(int j = 1; j < board[0].length-1; j++){
                if(bbo[i][j] != true){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int i, int j){
        if(i<0||j<0||i>r-1||j>c-1) return;
        if(board[i][j]=='X') return;
        if(bbo[i][j]==true) return;
        bbo[i][j]=true;
        if(i + 1 < r && board[i+1][j]=='O'){
            dfs(i+1, j);
        }
        if(i - 1 >= 0 && board[i-1][j]=='O'){
            dfs(i-1, j);
        }
        if(j + 1 < c && board[i][j+1]=='O'){
            dfs(i, j+1);
        }
        if(j - 1 >= 0 && board[i][j-1]=='O'){
            dfs(i, j-1);
        }
    }
}
