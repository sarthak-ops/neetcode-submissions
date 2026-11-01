class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> rot = new LinkedList<>();
        int fresh = 0;
        int min = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j]==2){
                    rot.add(new int[]{i, j});
                }
                if(grid[i][j] == 1) fresh++;
            }
        }
        while(!rot.isEmpty()){
            int size = rot.size();
            for(int i = 0; i < size; i++){
                int[] cur = rot.poll();
                if(cur[0]+1 < r && grid[cur[0]+1][cur[1]] == 1){
                    fresh--;
                    grid[cur[0]+1][cur[1]] = 2;
                    rot.add(new int[]{cur[0]+1, cur[1]});
                }
                if(cur[0]-1 >= 0 && grid[cur[0]-1][cur[1]] == 1){
                    fresh--;
                    grid[cur[0]-1][cur[1]] = 2;
                    rot.add(new int[]{cur[0]-1, cur[1]});
                }
                if(cur[1]+1 < c && grid[cur[0]][cur[1]+1] == 1){
                    fresh--;
                    grid[cur[0]][cur[1]+1] = 2;
                    rot.add(new int[]{cur[0], cur[1]+1});
                }
                if(cur[1]-1 >= 0 && grid[cur[0]][cur[1]-1] == 1){
                    fresh--;
                    grid[cur[0]][cur[1]-1] = 2;
                    rot.add(new int[]{cur[0], cur[1]-1});
                }
            }
            if (!rot.isEmpty()) {
                min++;
            }
        }
        return fresh == 0 ? min : -1;
    }
}
