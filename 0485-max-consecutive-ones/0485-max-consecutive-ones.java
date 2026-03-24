class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int len = 0;
        int countOnes = 0;
        while(i<n){
          if(nums[i] == 1){
            countOnes++;
          }else{
            countOnes = 0;
          }
          len = Math.max(len,countOnes);
          i++;
        }
        return len;
    }
}