class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1] = 0;
        for(int i=n-2;i>=0;i--){
           int jumps = 0;
           for(int j=1;j<=nums[i];j++){
            if(i+j < n){
            jumps = dp[i+j];
            if(jumps != Integer.MAX_VALUE) jumps = 1+jumps;
            dp[i] = Math.min(jumps,dp[i]);
            }
           }
        }
        return dp[0];
        //return minjumps(0,n,nums,dp);
    }
    static int minjumps(int index,int n,int[] nums,int[] dp){
        if(index >= n-1){
            return 0;
        }
        if(nums[index] == 0){
            return Integer.MAX_VALUE;
        }
        if(dp[index] != 0){
            return dp[index];
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++){
            int jumps = minjumps(index+i,n,nums,dp);
            if(jumps != Integer.MAX_VALUE){
              jumps = 1+jumps;
            }
            min = Math.min(min,jumps);
        }
        return dp[index] = min;
    }
}