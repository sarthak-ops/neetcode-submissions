class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> pos = new LinkedList<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 0){
                    pos.add(new int[]{i, j});
                }
            }
        }
        while(!pos.isEmpty()){
            int[] cur = pos.poll();
            // DOWN
            if(cur[0] + 1 < r && grid[cur[0] + 1][cur[1]] == Integer.MAX_VALUE){
                grid[cur[0] + 1][cur[1]] = grid[cur[0]][cur[1]] + 1;
                pos.add(new int[]{cur[0] + 1, cur[1]});
            }

            // UP
            if(cur[0] - 1 >= 0 && grid[cur[0] - 1][cur[1]] == Integer.MAX_VALUE){
                grid[cur[0] - 1][cur[1]] = grid[cur[0]][cur[1]] + 1;
                pos.add(new int[]{cur[0] - 1, cur[1]});
            }

            // RIGHT
            if(cur[1] + 1 < c && grid[cur[0]][cur[1] + 1] == Integer.MAX_VALUE){
                grid[cur[0]][cur[1] + 1] = grid[cur[0]][cur[1]] + 1;
                pos.add(new int[]{cur[0], cur[1] + 1});
            }

            // LEFT
            if(cur[1] - 1 >= 0 && grid[cur[0]][cur[1] - 1] == Integer.MAX_VALUE){
                grid[cur[0]][cur[1] - 1] = grid[cur[0]][cur[1]] + 1;
                pos.add(new int[]{cur[0], cur[1] - 1});
            }
        }
    }
}
