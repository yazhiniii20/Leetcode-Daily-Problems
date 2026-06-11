class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for(int i=0;i<n;i++) totalSum += nums[i];
        if(totalSum-target < 0 || (totalSum-target)%2 != 0) return 0;
        return findWays(n-1,nums,(totalSum-target)/2);
    }
    static int findWays(int index,int[] nums,int t){
        if(index == 0){
            if(nums[index] == 0 && t == 0) return 2;
            if(nums[index] == t || t == 0) return 1;
            else return 0;
        }
        int notTake = findWays(index-1,nums,t);
        int take = 0;
        if(nums[index] <= t) take = findWays(index-1,nums,t-nums[index]);
        return notTake+take;
    }
}