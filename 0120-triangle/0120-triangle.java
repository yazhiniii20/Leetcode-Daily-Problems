class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diagonal = triangle.get(i).get(j) +dp[i+1][j+1];
                dp[i][j] = Math.min(down,diagonal);
            }
        }
        return dp[0][0];
        //return minPath(triangle,0,0,dp);
    }
    static int minPath(List<List<Integer>> triangle,int row,int col,Integer[][] dp){
        if(row >= triangle.size()-1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col] != null){
            return dp[row][col];
        }
        int sum = 0;
        sum += triangle.get(row).get(col) + Math.min(minPath(triangle,row+1,col,dp),minPath(triangle,row+1,col+1,dp));
        return dp[row][col] = sum;
    }
}