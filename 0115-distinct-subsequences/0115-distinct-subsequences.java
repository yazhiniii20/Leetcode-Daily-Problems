class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        Integer[][] dp = new Integer[m+1][n+1];
        return countWays(m-1,n-1,s,t,dp);
    }
    static int countWays(int i,int j,String s,String t,Integer[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;
        
        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)) return dp[i][j] = countWays(i-1,j-1,s,t,dp) + countWays(i-1,j,s,t,dp);
        else return dp[i][j] = countWays(i-1,j,s,t,dp);
    }
}