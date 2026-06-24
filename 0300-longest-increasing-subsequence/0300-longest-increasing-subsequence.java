class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int index = n-1; index >= 0; index--){
            for(int prevIndex = index-1 ;prevIndex >= -1; prevIndex--){
                int len = 0 + dp[index+1][prevIndex+1];
                if(prevIndex == -1 || nums[index] > nums[prevIndex]){
                  len = Math.max(len , 1 + dp[index+1][index+1]);
                }
               dp[index][prevIndex+1] = len;    
            }
        }
        return dp[0][0];
        //return lenLIS(0,-1,nums,dp);
    }
    static int lenLIS(int index,int prevIndex,int[] nums,Integer[][] dp){
    if(index == nums.length) return 0;

    if(dp[index][prevIndex+1] != null) return dp[index][prevIndex+1];

    int len = 0 + lenLIS(index+1,prevIndex,nums,dp);

    if(prevIndex == -1 || nums[index] > nums[prevIndex]){
        len = Math.max(len , 1 + lenLIS(index+1,index,nums,dp));
    }
    return dp[index][prevIndex+1] = len;        
   }
}