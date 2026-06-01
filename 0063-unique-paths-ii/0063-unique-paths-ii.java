class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return paths(obstacleGrid,m-1,n-1,dp);
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