class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        Integer[][] dp = new Integer[n+1][m+1];
        return editDistance(n-1,m-1,word1,word2,dp);
    }
    static int editDistance(int i,int j,String s1,String s2,Integer[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        
        if(dp[i][j] != null) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 0 + editDistance(i-1,j-1,s1,s2,dp);
        return dp[i][j] = 1 + Math.min(editDistance(i,j-1,s1,s2,dp) , Math.min(editDistance(i-1,j,s1,s2,dp) , editDistance(i-1,j-1,s1,s2,dp)));         
    }
}