class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        int profit = 0;
        for(int index=n-1; index>=0; index--){
            for(int buy=0; buy<=1 ; buy++){
            if(buy == 1) profit = Math.max(-prices[index] + dp[index+1][0], 0 + dp[index+1][1]);
            else profit = Math.max(prices[index] + dp[index+2][1],0 + dp[index+1][0]);
            dp[index][buy] = profit;
            }
        }
        return dp[0][1];
        //return findmaxProfit(0,1,prices,dp);
    }
    static int findmaxProfit(int index,int buy,int[] prices,Integer[][] dp){
        if(index >= prices.length) return 0;
        if(dp[index][buy] != null) return dp[index][buy];
        int profit = 0;
        if(buy == 1){
        profit = Math.max(-prices[index] + findmaxProfit(index+1,0,prices,dp), 0 + findmaxProfit(index+1,1,prices,dp));
        }else{
            profit = Math.max(prices[index] + findmaxProfit(index+2,1,prices,dp),0 + findmaxProfit(index+1,0,prices,dp));
        }
        return dp[index][buy] = profit;
    }
}