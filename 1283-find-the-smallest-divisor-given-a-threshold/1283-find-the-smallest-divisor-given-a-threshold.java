class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
        }
        int high = max;
        int ans = 0;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(isMinDivisor(nums,mid,threshold)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    static boolean isMinDivisor(int[] nums,int mid,int threshold){
        double sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += Math.ceil((double) nums[i]/mid);
        }
        return ((int)sum <= threshold);
    }
}