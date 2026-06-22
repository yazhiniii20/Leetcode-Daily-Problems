class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n+1][2];
        return findMaxProfit(0,1,prices,0,dp);
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