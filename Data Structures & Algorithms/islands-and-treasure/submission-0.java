class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = Integer.MAX_VALUE;
        Queue<int[]> x = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    x.offer(new int[]{i, j});
                }
            }
        }
        while(!x.isEmpty()){
            int[] pair = x.poll();
            int row = pair[0];
            int col = pair[1];
            if(row+1 < grid.length && grid[row+1][col] == INF){
                grid[row+1][col] = grid[row][col] + 1;
                x.offer(new int[]{row+1, col});
            }
            if(row-1 >= 0 && grid[row-1][col] == INF){
                grid[row-1][col] = grid[row][col] + 1;
                x.offer(new int[]{row-1, col});
            }
            if(col+1 < grid[0].length && grid[row][col+1] == INF){
                grid[row][col+1] = grid[row][col] + 1;
                x.offer(new int[]{row, col+1});
            }
            if(col-1 >= 0 && grid[row][col-1] == INF){
                grid[row][col-1] = grid[row][col] + 1;
                x.offer(new int[]{row, col-1});
            }
        }
    }
}
