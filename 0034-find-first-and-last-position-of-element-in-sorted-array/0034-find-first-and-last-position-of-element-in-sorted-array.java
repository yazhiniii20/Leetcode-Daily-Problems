class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int n = nums.length;
        int[] positions = new int[2];
        first = lower_bound(nums,target);
        if(first == n || nums[first] != target){
            return new int[]{-1,-1};
        }
        last = upper_bound(nums,target)-1;
        positions[0] = first;
        positions[1] = last;
        return positions;
    }
    static int lower_bound(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int index = nums.length;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid] >= target){
              index = mid;
              high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return index;
    }
    static int upper_bound(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int index = nums.length;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid] > target){
              index = mid;
              high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return index;
    }
}