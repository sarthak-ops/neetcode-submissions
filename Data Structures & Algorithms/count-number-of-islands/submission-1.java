class Solution {
    char[][] grid;
    int r;
    int c;
    boolean[][] bgrid;
    public int numIslands(char[][] grid) {
        int ans = 0;
        this.grid = grid;
        this.r = grid.length;
        this.c = grid[0].length;
        this.bgrid = new boolean[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j]=='1' && bgrid[i][j]==false){
                    fill(i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void fill(int i, int j){
        if(i < 0 || j < 0 || i >= r || j >= c){
            return;
        }
        if(bgrid[i][j]==true){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        bgrid[i][j] = true;
        fill(i+1, j);
        fill(i, j+1);
        fill(i-1, j);
        fill(i, j-1);
    }
}
