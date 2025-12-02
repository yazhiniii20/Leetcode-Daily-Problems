class Solution {
    public boolean isPowerOfFour(int n) {
        while(n == 1 || n == 4){
            return true;
        }
        int i = 1;
        while(i > 0){
            i = i*4;
            if(i == n){
                return true;
            }
            if(i > n){
                break;
            }
        }
        return false;
    }
}