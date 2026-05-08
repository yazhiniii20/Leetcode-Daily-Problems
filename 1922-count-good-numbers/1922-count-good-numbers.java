class Solution {
    static final long MOD = 1000000007;
    public int countGoodNumbers(long n) {
       long oddCount = n/2;
       long evenCount = n - oddCount;
       long ans = (power(4,oddCount,1)*power(5,evenCount,1))%MOD;
       return (int)ans;
    }
    static long power(long x,long n,long ans){
        if(n == 0){
            return ans;
        }
        if(n%2 == 0){
            x  = (x*x)%MOD;
            n /= 2;
        }else{
            ans = (ans*x)%MOD;
            n = n-1;
        }
        return power(x,n,ans);
    }
}