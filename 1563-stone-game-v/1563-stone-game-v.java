class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] =  prefix[i] + stoneValue[i];
        Integer[][] dp = new Integer[n][n];
        return solve(0, n - 1, prefix, dp);
    }
    static int solve(int left,int right,int[] prefix,Integer[][] dp) {
        // Only one stone
        if (left == right) return 0;
        if (dp[left][right] != null) return dp[left][right];
        int ans = 0;
        for (int k = left; k < right; k++) {
            int leftSum =  prefix[k + 1] - prefix[left];
            int rightSum = prefix[right + 1] - prefix[k + 1];

            if (leftSum < rightSum) {
                ans = Math.max(ans,leftSum + solve(left,k,prefix,dp));
            } else if (leftSum > rightSum) {
                ans = Math.max(ans,rightSum + solve(k + 1,right,prefix,dp));
            } else {
                ans = Math.max(ans,leftSum + Math.max(solve(left, k, prefix, dp),
                solve(k + 1, right, prefix, dp)));
            }
        }
        return dp[left][right] = ans;
    }
}