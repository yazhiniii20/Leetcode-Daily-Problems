class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int i=1;
        int j=0;
        temp[0] = nums[0];
        while(i<n){
            temp[i] = nums[i]+temp[j];
            i++;
            j++;
        }
        return temp;
    }
}