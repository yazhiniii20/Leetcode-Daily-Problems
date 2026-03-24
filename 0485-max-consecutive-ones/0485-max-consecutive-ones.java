class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int len = 0;
        while(i<n && j<n){
            if(nums[j] == 1){
                j++;
            }else{
                j++;
                i=j;
            }
             len = Math.max(len,j-i);
        }
        return len;
    }
}