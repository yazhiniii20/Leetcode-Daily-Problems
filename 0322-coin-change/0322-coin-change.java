class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        int ans  = minCoins(n-1,coins,amount,dp);
        return (ans >= (int)1e9)?-1:ans;
    }
    static int minCoins(int index,int[] coins,int amount,int[][] dp){
        if(index == 0){
            if((amount%coins[index]) == 0) return amount/coins[index];
            else  return (int)1e9;
        }
        if(dp[index][amount] != -1) return dp[index][amount];
        int notTake = 0;
        int take = Integer.MAX_VALUE;
        notTake = 0+minCoins(index-1,coins,amount,dp);
        if(coins[index] <= amount)  take = 1+minCoins(index,coins,amount-coins[index],dp);
        return dp[index][amount] = Math.min(take,notTake);
    }
}