class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        for(int stones=1;stones<=n;stones++){
           for(int x=1;x*x<=stones;x++){
              int square = x*x;
              if(!dp[stones-square]){
                  dp[stones] = true;
                  break;
              }
           }
        }
        return dp[n];
    }
}