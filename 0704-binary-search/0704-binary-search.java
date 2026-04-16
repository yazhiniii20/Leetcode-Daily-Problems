class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return bs(nums,0,n-1,target);
    }
    static int bs(int[] nums,int low,int high,int target){
        if(low > high){
            return -1;
        }
        int mid = low+(high-low)/2;
        if(nums[mid] == target){
          return mid;
        }else if(nums[mid] > target){
            return bs(nums,low,mid-1,target);
        }else{
            return bs(nums,mid+1,high,target);
        }
    }
}