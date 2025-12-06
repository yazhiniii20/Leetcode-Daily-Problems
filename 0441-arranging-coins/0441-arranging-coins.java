class Solution {
    public int arrangeCoins(int n) {
        int row = 0;
        int i=0;
        while(n >= 0){
           n = n-i;
           i++;
           row++;
        }
        return row-2;
    }
}