class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] dp = new Integer[n][n];
        int ans = f(0,n-1,piles,dp);
        return (ans < 0)?false:true;        
    }
    static int f(int start,int end,int[] piles,Integer[][] dp){
        if(start == end) return piles[start];

        if(dp[start][end] != null) return dp[start][end];

        int left = piles[start] - f(start+1,end,piles,dp);
        int right = piles[end] - f(start,end-1,piles,dp);

        return dp[start][end] = Math.max(left,right);
    }
}