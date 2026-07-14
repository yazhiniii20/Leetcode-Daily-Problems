class Solution {
    static final int MOD = 1_000_000_007;
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        Integer[][][] dp = new Integer[n+1][201][201];
        return findPair(0,0,0,nums,dp);
    }
    static int findPair(int index,int gcd1,int gcd2,int[] nums,Integer[][][] dp){
        if(index == nums.length){
            return (gcd1 > 0 && gcd2 > 0 && gcd1 == gcd2)? 1 : 0;
        }

        if(dp[index][gcd1][gcd2] != null) return dp[index][gcd1][gcd2];
        
        long notTake = findPair(index+1,gcd1,gcd2,nums,dp);
        long takeGcd1 = findPair(index+1,gcd(nums[index],gcd1),gcd2,nums,dp);
        long takeGcd2 = findPair(index+1,gcd1,gcd(nums[index],gcd2),nums,dp);

        long ans = (notTake + takeGcd1) % MOD;
        ans = (ans + takeGcd2) % MOD;

        return dp[index][gcd1][gcd2] = (int) ans;
    }
    static int gcd(int m,int n){
        while(n > 0){
            int rem = m%n;
            m = n;
            n = rem;
        }
        return m;
    }
}