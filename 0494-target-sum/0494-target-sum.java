class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;
        int totalSum = 0;
        for(int i=0;i<n;i++) totalSum += arr[i];
        if(totalSum-target < 0 || (totalSum-target)%2 != 0) return 0;
        int sum = (totalSum-target)/2;
        int[][] dp = new int[n][sum+1];
        dp[0][0] = 2;
        if(arr[0] == 0){
            dp[0][0] = 2;
        }else{
            dp[0][0] = 1;
            if(arr[0] <= sum) dp[0][arr[0]] = 1;
        }
        for(int index=1; index<n; index++){
            for(int t = 0; t <= sum; t++){
               int notTake = dp[index-1][t];
               int take = 0;
               if(t >= arr[index]) take = dp[index-1][t-arr[index]];
               dp[index][t] = take+notTake;
            }
        }
        return dp[n-1][sum];
        //return findWays(n-1,nums,(totalSum-target)/2);
    }
    static int findWays(int index,int[] nums,int t){
        if(index == 0){
            if(nums[index] == 0 && t == 0) return 2;
            if(nums[index] == t || t == 0) return 1;
            else return 0;
        }
        int notTake = findWays(index-1,nums,t);
        int take = 0;
        if(nums[index] <= t) take = findWays(index-1,nums,t-nums[index]);
        return notTake+take;
    }
}