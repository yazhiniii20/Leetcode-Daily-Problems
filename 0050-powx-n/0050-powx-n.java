class Solution {
    public double myPow(double x, int n) {
        long num = n;
        double ans = 1.0;
        if(num < 0){
            num = -1*num;
        }
        ans = computePow(x,num,ans);
        if(n<0){
            ans = (double)1.0/ans;
        }
        return ans;
    }
    static double computePow(double x,long n,double ans){
        if(n <= 0){
            return ans;
        }
        if(n%2 == 0){
            x *= x;
            n /= 2;
        }else{
            ans *= x;
            n = n-1;
        }
        return computePow(x,n,ans);
    }
}