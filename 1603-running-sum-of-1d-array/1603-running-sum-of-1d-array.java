class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int i=1;
        int j=0;
        while(i<n){
            nums[i] += nums[j];
            i++;
            j++;
        }
        return nums;
    }
}