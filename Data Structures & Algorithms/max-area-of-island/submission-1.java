class Solution {
    int[][] grid;
    int r;
    int c;
    boolean[][] bgrid;
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        this.grid = grid;
        this.r = grid.length;
        this.c = grid[0].length;
        this.bgrid = new boolean[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j]==1 && bgrid[i][j]==false){
                    int cur = fill(i, j);
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }
    public int fill(int i, int j){
        if(i < 0 || j < 0 || i >= r || j >= c){
            return 0;
        }
        if(bgrid[i][j]==true){
            return 0;
        }
        if(grid[i][j]==0){
            return 0;
        }
        bgrid[i][j] = true;
        return 1 + fill(i+1, j) + fill(i, j+1) + fill(i-1, j) + fill(i, j-1);
    }
}
