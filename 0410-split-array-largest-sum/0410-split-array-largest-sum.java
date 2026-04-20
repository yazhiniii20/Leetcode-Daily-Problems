class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = 0;
        for(int i=0;i<n;i++){
            low = Math.max(low,nums[i]);
            high += nums[i];
        }
        int ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(canSplit(nums,mid,k)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    static boolean canSplit(int[] nums,int limit,int k){
        int splitCount = 1;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > limit){
                return false;
            }
            if(nums[i]+sum > limit){
                splitCount++;
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            if(splitCount > k) return false;
        }
        return true;
    }
}