class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        int[] prefixGcd = new int[n];
        for(int i=0;i<n;i++){
           max = Math.max(max,nums[i]);
           prefixGcd[i] = gcd(nums[i],max);
        }
        Arrays.sort(prefixGcd);
        long sum = 0;
        for(int i=0;i<n/2;i++){
            sum += gcd(prefixGcd[i],prefixGcd[n-i-1]);
        }
        return sum;
    }
   static int gcd(int a, int b) {
         while(a > 0){
            int rem = b%a;
            b = a;
            a = rem;
        }
        return b;
    }
}