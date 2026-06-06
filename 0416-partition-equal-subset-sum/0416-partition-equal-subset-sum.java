class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i=0;i<n;i++) totalSum += nums[i];
        if(totalSum%2 != 0) return false;
        int sum = totalSum/2;
        boolean[][] dp = new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if(nums[0] <= sum) dp[0][nums[0]] = true;
        for(int i=1;i<n;i++){
            for(int target=1;target<=sum;target++){
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(target >= nums[i])  take = dp[i-1][target-nums[i]];
                dp[i][target] = (notTake || take);
            }
        }
        return dp[n-1][sum];
        //return subsetSumEqualsTarget(n-1,nums,sum,dp);
    }
    static boolean subsetSumEqualsTarget(int index,int[] nums,int target,Boolean[][] dp){
        if(target == 0) return true;
        if(index == 0){
            return (nums[index] == target);
        }
        if(dp[index][target] != null) return dp[index][target]; 
        boolean notTake = subsetSumEqualsTarget(index-1,nums,target,dp);
        boolean take = false;
        if(target >= nums[index]){
            take = subsetSumEqualsTarget(index-1,nums,target-nums[index],dp);
        }
        return dp[index][target] = (notTake || take);
    }
}