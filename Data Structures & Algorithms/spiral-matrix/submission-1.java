class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] steps = {matrix[0].length, matrix.length-1};
        int d = 0, r = 0, c = -1;
        while(steps[d % 2] > 0){
            for(int i = 0; i < steps[d%2]; i++){
                r += dirs[d][0];
                c += dirs[d][1];
                ans.add(matrix[r][c]);
            }
            steps[d % 2]--;
            d = (d+1) % 4;
        }
        return ans;
    }
}
