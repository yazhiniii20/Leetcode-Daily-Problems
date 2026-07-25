class Solution {
    public int maxProduct(int n) {
        int ans = 0;
        int firstmax = 0;
        int secondmax = 0;
        while(n > 0){
            ans = n%10;
            if(ans >= firstmax){
                secondmax = firstmax;
                firstmax = ans;
            }else if(ans <= firstmax && ans >= secondmax){
                secondmax = ans;
            }
            n = n/10;
        }
        return firstmax*secondmax;
    }
}