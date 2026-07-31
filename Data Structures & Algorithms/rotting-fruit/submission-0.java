class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> x = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2){
                    x.offer(new int[]{i, j});
                }
            }
        }
        while(!x.isEmpty()){
            int size = x.size();
            for(int i = 0; i < size; i++){
                int[] cur = x.poll();
                int row = cur[0];
                int col = cur[1];
                if(row + 1 < grid.length && grid[row+1][col] == 1){
                    grid[row+1][col] = 2;
                    x.offer(new int[]{row+1, col});
                    fresh--;
                }
                if(row - 1 >= 0 && grid[row-1][col] == 1){
                    grid[row-1][col] = 2;
                    x.offer(new int[]{row-1, col});
                    fresh--;
                }
                if(col + 1 < grid[0].length && grid[row][col+1] == 1){
                    grid[row][col+1] = 2;
                    x.offer(new int[]{row, col+1});
                    fresh--;
                }
                if(col - 1 >= 0 && grid[row][col-1] == 1){
                    grid[row][col-1] = 2;
                    x.offer(new int[]{row, col-1});
                    fresh--;
                }
            }
            if (!x.isEmpty()) {
                minutes++;
            }
        }
        return fresh == 0? minutes : -1;
        // if(fresh == 0){
        //     return minutes;
        // }
        // else{
        //     return -1;
        // }
    }
}
