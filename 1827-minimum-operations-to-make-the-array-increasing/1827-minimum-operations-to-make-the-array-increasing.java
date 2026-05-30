class Solution {
    public int minOperations(int[] nums) {
      int n = nums.length;
      if(n == 1){
        return 0;
      }
      int max = 0;
      int count = 0;
      for(int i=1;i<n;i++){
        int prev = nums[i];
        nums[i] = Math.max(nums[i-1]+1,nums[i]);
        count += Math.abs(prev-nums[i]);
      }
      return count;
    }
}