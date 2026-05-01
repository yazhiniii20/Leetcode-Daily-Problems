class Solution {
    public int maxRotateFunction(int[] nums) {
        int totalSum=0;
        int f0 = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
           totalSum += nums[i];
           f0 += (i*nums[i]);
        }
        int max = f0;
        int current = f0;
        for(int k=1;k<n;k++){
            current = current+totalSum-(n*nums[n-k]);
            max = Math.max(max,current);
        }
        return max;
    }
   
}