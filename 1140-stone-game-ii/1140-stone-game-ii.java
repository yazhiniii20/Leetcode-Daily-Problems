class Solution {
    public int stoneGameII(int[] piles) {
        int total = 0;
        for(int i : piles) total += i;
        int n = piles.length;
        Integer[][] dp = new Integer[n][n+1];
        int diff = solve(0,1,piles,dp);
        return (total+diff)/2;
    }
    static int solve(int index,int M,int[] piles,Integer[][] dp){
        int n = piles.length;
        if(index >= n) return 0;
        if(dp[index][M] != null) return dp[index][M];
        int sum = 0;
        int best = Integer.MIN_VALUE;
        for(int X=1;X<=2*M && index+X <= n;X++){
           sum += piles[index+X-1];
           int nextM = Math.max(M,X);
           int opponent = solve(index+X,nextM,piles,dp);
           int current = sum-opponent;
           best = Math.max(best,current);
        }
        return dp[index][M] = best;
    }
}