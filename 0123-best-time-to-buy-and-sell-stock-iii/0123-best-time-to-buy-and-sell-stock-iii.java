class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
       Integer[][][] dp = new Integer[n+1][2][3];
       return possibleProfit(0,1,prices,2,dp); 
    }
    static int possibleProfit(int index,int buy,int[] prices,int transactions,Integer[][][] dp){
     if(transactions == 0 || index == prices.length) return 0;

     if(dp[index][buy][transactions] != null) return dp[index][buy][transactions];

     int profit = 0;

     if(buy == 1){
        profit = Math.max(-prices[index] + possibleProfit(index+1,0,prices,transactions,dp),
        0 + possibleProfit(index+1,1,prices,transactions,dp));
     }else{
        profit = Math.max(prices[index] + possibleProfit(index+1,1,prices,transactions-1,dp),
        0 + possibleProfit(index+1,0,prices,transactions,dp));
     }
     return dp[index][buy][transactions] = profit;
    }
}