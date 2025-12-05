class Solution {
    public int countPartitions(int[] nums) {
        int partitions = 0;
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
        }
       return (totalSum%2 == 0)?nums.length-1:0;
    }
}