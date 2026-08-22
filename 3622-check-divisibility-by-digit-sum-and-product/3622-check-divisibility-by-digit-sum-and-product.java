class Solution {
    public boolean checkDivisibility(int n) {
        int sum = computeSum(n);
        int product = computeProduct(n);
        return (n%(sum+product) == 0);
    }
    static int computeSum(int n){
        int sum = 0;
        while(n > 0){
            sum += (n%10);
            n /= 10;
        }
        return sum;
    }
    static int computeProduct(int n){
        int product = 1;
        while(n > 0){
            product *= (n%10);
            n /= 10;
        }
        return product;
    }
}