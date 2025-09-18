class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for(int i=0;i<n;i++){
            temp[i] = howManySmaller(nums[i],nums);
        }
         return temp;
    }
    private static int howManySmaller(int num,int[] nums){
        int small=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == num){
                continue;
            }else{
                if(nums[i] < num){
                   small++;
                }
            }
        }
        return small;
    }
}