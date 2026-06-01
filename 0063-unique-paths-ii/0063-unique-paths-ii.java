class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
             if(i == 0 && j == 0 && obstacleGrid[i][j] != 1){
                dp[i][j] = 1;
             }else if(obstacleGrid[i][j] == 1){
                dp[i][j] = 0;
            }else{
                int up = 0;
                int down = 0;
                if(i > 0)   up = dp[i-1][j];
                if(j > 0)   down = dp[i][j-1];
                dp[i][j] = up+down;
             }
          }
        }
        return dp[m-1][n-1];
        //return paths(obstacleGrid,m-1,n-1,dp);
    }
    static int paths(int[][] obstacleGrid,int i,int j,int[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }        
        if(obstacleGrid[i][j] == 1){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        int left = paths(obstacleGrid,i,j-1,dp);
        int up = paths(obstacleGrid,i-1,j,dp);
        return dp[i][j] = left+up;
    }
}