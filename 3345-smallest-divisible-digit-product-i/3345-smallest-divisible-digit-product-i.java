class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;
        int p = 1;
        while(p > 0){
             p = product(num);
             if(p%t == 0) return num;
             num++;
        }
        return num;
    }
    static int product(int num){
        int p = 1;
        while(num > 0){
          p *= (num%10);
          num = num/10;
        }
        return p;
    }
}