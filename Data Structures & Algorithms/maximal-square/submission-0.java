class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int l = 0;
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[0].length - 1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]));
                    l = Math.max(l, dp[i][j]);
                }
            }
        }
        return l * l;
    }
}