class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        int ans = f(0,n-1,nums,dp);
        return (ans < 0)? false : true;
    }
    static int f(int left,int right,int[] nums,Integer[][] dp){
        if(left == right) return nums[left];

        if(dp[left][right] != null) return dp[left][right];

        int leftPick = nums[left] - f(left+1,right,nums,dp);
        int rightPick = nums[right] - f(left,right-1,nums,dp);
        
        return dp[left][right] = Math.max(leftPick,rightPick);
    }
}