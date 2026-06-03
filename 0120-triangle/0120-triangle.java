class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return minPath(triangle,0,0,dp);
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