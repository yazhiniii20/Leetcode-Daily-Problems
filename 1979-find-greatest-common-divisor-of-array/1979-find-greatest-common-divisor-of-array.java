class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        for(int i=1;i<n;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        return gcd(min,max);
    }
    static int gcd(int a,int b){
        while(a > 0){
            int rem = b%a;
            b = a;
            a = rem;
        }
        return b;
    }
}