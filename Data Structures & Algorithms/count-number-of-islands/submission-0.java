class Solution {
    char[][] grid;
    int rows;
    int cols;
    int ans;
    boolean[][] islands;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.islands = new boolean[rows][cols];
        ans = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1' && islands[i][j] != true){
                    ans++;
                    dfs(i, j);
                }   
            }
        }
        return ans;
    }
    
    public void dfs(int i, int j){
        if(i < 0 || j < 0 || i >= rows || j >= cols){
            return;
        }
        if(grid[i][j] == '0'){
            return;
        }
        if(islands[i][j] == true){
            return;
        }
        islands[i][j] = true;
        dfs(i+1, j);
        dfs(i-1, j);
        dfs(i, j+1);
        dfs(i, j-1);
    }
}
