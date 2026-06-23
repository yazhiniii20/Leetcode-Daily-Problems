class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        Integer[][] dp = new Integer[n+1][2];
        return findmaxProfit(0,1,fee,prices,dp);
    }
    static int findmaxProfit(int index,int buy,int fee,int[] prices,Integer[][] dp){
        if(index == prices.length) return 0;
        if(dp[index][buy] != null) return dp[index][buy];
        int profit=0;
        if(buy == 1){
         profit = Math.max(-prices[index]+findmaxProfit(index+1,0,fee,prices,dp) , 0+findmaxProfit(index+1,1,fee,prices,dp));
        }else{
            profit = Math.max(prices[index]+findmaxProfit(index+1,1,fee,prices,dp)-fee, 0+findmaxProfit(index+1,0,fee,prices,dp));
        }
        return dp[index][buy] = profit;
    }
}