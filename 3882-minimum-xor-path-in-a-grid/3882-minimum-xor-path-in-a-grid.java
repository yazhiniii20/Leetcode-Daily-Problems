class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][1024];
        return findMinCost(grid,0,0,0,dp);
    }
    static int findMinCost(int[][] grid,int i,int j,int xor,Integer[][][] dp){
        if(i >= grid.length || j >= grid[0].length) return (int)1e9;
               
        xor = xor^grid[i][j];

        if(dp[i][j][xor] != null) return dp[i][j][xor];

        if(i == grid.length-1 && j == grid[0].length-1) return xor;

        
        int right = findMinCost(grid,i,j+1,xor,dp);
        int down = findMinCost(grid,i+1,j,xor,dp);

        return dp[i][j][xor] = Math.min(right,down);    
        
    }
}