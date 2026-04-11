class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int longest = 1;
        int count = 0;
        int lastSmaller = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]-1 == lastSmaller){
                count++;
                lastSmaller = nums[i];
            }else if(lastSmaller != nums[i]){
                lastSmaller = nums[i];
                count = 1;
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
}