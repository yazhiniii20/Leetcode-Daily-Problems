class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n == 1 && nums[0] == 0){
            return;
        }
        int i=0;
        int j=1;
        while(i < n && j < n){
            if((nums[i] == 0 && nums[j] != 0) ||(nums[j] == 0 && nums[i] != 0) ){
                 int temp = nums[i];
                 nums[i] = nums[j];
                 nums[j] = temp;
                 i++;
                 j++;
            }else{
            j++;
        }
    }
}
}