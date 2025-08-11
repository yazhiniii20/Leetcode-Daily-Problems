class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int inc=1;
        int dec=1;
        int len=1;
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]){
              inc++;
              dec=1;
            }
            else if(nums[i] < nums[i-1]){
                dec++;
                inc=1;
            }
            else if(nums[i] == nums[i-1]){
                inc=1;
                dec=1;
            }
            len = Math.max(len,Math.max(inc,dec));
        }
        return len;
    }
}