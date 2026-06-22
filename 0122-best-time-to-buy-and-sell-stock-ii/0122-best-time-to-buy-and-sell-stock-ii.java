class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        int profit = 0;
        dp[n][0] = 0;
        dp[n][1] = 0;
        for(int index=n-1;index>=0;index--){
          for(int buy=0;buy<=1;buy++){
            if(buy == 1){
            profit = Math.max(-prices[index] + dp[index+1][0], 0 +dp[index+1][1]);
        }else{
            profit = Math.max(prices[index] + dp[index+1][1], 0 + dp[index+1][0]);
          }
          dp[index][buy] = profit;
        }
     }
     return dp[0][1];
        //return findMaxProfit(0,1,prices,0,dp);
    }
    static int findMaxProfit(int index,int buy,int[] prices,int profit,Integer[][] dp){
        if(index == prices.length) return 0;

        if(dp[index][buy] != null) return dp[index][buy];

        if(buy == 1){
          dp[index][buy] = Math.max(-prices[index] + findMaxProfit(index+1,0,prices,profit,dp),0 + findMaxProfit(index+1,1,prices,profit,dp));
        }else{
            dp[index][buy] = Math.max(prices[index] + findMaxProfit(index+1,1,prices,profit,dp),0 + findMaxProfit(index+1,0,prices,profit,dp));
        }
        return dp[index][buy];
    }
}