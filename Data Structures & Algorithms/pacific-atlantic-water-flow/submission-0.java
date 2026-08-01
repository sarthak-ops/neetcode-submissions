class Solution {
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++){
            dfs(i, 0, pacific);
        }
        for(int j = 0; j < heights[0].length; j++){
            dfs(0, j, pacific);
        }
        for(int i = 0; i < heights.length; i++){
            dfs(i, heights[0].length-1, atlantic);
        }
        for(int j = 0; j < heights[0].length; j++){
            dfs(heights.length-1, j, atlantic);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
    public void dfs(int row, int col, boolean[][] ocean){
        if(row < 0 || col < 0 || row >= ocean.length || col >= ocean[0].length){
            return;
        }
        if(ocean[row][col] == true){
            return;
        }
        ocean[row][col] = true;
        if(row + 1 < heights.length && heights[row+1][col] >= heights[row][col]){
            dfs(row+1, col, ocean);
        }
        if(row - 1 >= 0 && heights[row-1][col] >= heights[row][col]){
            dfs(row-1, col, ocean);
        }
        if(col + 1 < heights[0].length && heights[row][col+1] >= heights[row][col]){
            dfs(row, col+1, ocean);
        }
        if(col - 1 >= 0 && heights[row][col-1] >= heights[row][col]){
            dfs(row, col-1, ocean);
        }
    }
}
