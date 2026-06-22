class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int [][][] dp = new int[n+1][2][k+1];
        int profit = 0;
        for(int index = n-1; index >= 0;index --){
            for(int buy = 0; buy <= 1; buy++){
                for(int transactions=k;transactions > 0; transactions--){
                if(buy == 1){
    profit = Math.max(-prices[index] + dp[index+1][0][transactions],0 + dp[index+1][1][transactions]);
     }else{
    profit = Math.max(prices[index] + dp[index+1][1][transactions-1],0 + dp[index+1][0][transactions]);
     }
                dp[index][buy][transactions] = profit;
                }
            }
        }
        return dp[0][1][k];
        //return possibleProfit(0,1,prices,k,dp); 
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