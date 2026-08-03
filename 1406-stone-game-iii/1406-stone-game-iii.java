class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] dp = new Integer[n+1];
        int ans = solve(0,n,stoneValue,dp);
        if(ans == 0){
            return "Tie";
        }
        return(ans < 0)?"Bob":"Alice";
    }
    static int solve(int index,int n,int[] stoneValue,Integer[] dp){
        if(index == n) return 0;
        if(dp[index] != null) return dp[index];

        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0;i<3;i++){ 
           if(index+i >= n) break;
           sum += stoneValue[index+i];
           ans = Math.max(ans,sum-solve(index+i+1,n,stoneValue,dp));
        }
        return dp[index] = ans;
    }
}