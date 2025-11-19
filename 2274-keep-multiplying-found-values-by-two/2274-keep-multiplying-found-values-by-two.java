class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        Arrays.sort(nums);
        int target = 0;
        while(target >=0 && target < n){
            target = Arrays.binarySearch(nums,original);
            if(target <= -1){
                break;
            }
            original *= 2;
        }
        return original;
    }
}