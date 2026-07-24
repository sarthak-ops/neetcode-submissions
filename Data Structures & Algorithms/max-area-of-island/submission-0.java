class Solution {
    int[][] grid;
    int rows;
    int cols;
    int max;
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] != true && grid[i][j] == 1){
                    int curmax = dfs(i, j);
                    max = Math.max(max, curmax);
                }
            }
        }
        return max;
    }
    public int dfs(int row, int col){
        if(row < 0 || col < 0){
            return 0;
        }
        if(row >= rows || col >= cols){
            return 0;
        }
        if(grid[row][col] == 0){
            return 0;
        }
        if(visited[row][col] == true){
            return 0;
        }
        visited[row][col] = true;
        return 1 + dfs(row+1, col) + dfs(row-1, col) + dfs(row, col+1) + dfs(row, col-1);
    }
}
