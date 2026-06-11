class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        return totalWays(n-1,amount,coins,dp);
    }
    static int totalWays(int index,int target,int[] coins,int[][] dp){
        if(index == 0){
          if((target%coins[index]) == 0) return 1;
          else return 0;
        }
        if(dp[index][target] != -1) return dp[index][target];
        int notTake = totalWays(index-1,target,coins,dp);
        int take = 0;
        if(coins[index] <= target) take = totalWays(index,target-coins[index],coins,dp);
        return dp[index][target] = take+notTake;
    }
}