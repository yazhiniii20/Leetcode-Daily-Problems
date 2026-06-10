class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int t=0;t<=amount;t++){
            if((t%coins[0]) == 0) dp[0][t] = t/coins[0];
            else dp[0][t] = (int)1e9;
        }
        for(int index=1;index<n;index++){
            for(int target=0;target<=amount;target++){
                int take = Integer.MAX_VALUE;
                int notTake = 0+dp[index-1][target];
                if(coins[index] <= target)  take = 1+dp[index][target-coins[index]];
                dp[index][target] = Math.min(take,notTake);
            }
        }
        int ans  = dp[n-1][amount];
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