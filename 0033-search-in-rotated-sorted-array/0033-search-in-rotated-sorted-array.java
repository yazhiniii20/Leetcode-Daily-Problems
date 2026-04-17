class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                 return mid;
            }
            //Checking whether left half is sorted
            if(nums[low] <= nums[mid]){
                //figure out whether the element lies in the left half
              if(nums[mid] >= target && nums[low] <= target){
                high = mid-1;
              }else{
                low = mid+1;
              }
            }
            //if not right half must be sorted
            else{
                //figure out whether the element lies in the right half
                if(nums[mid] <= target && nums[high] >= target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}