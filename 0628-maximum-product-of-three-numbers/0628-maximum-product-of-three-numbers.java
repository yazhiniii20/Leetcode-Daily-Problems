class Solution {
    public int maximumProduct(int[] nums) {
        // int firstmax = Integer.MIN_VALUE;
        // int secondmax = Integer.MIN_VALUE;
        // int thirdmax = Integer.MIN_VALUE;

        // int firstmin = Integer.MAX_VALUE;
        // int secondmin = Integer.MAX_VALUE;

        int n = nums.length;

        // for(int i=0;i<n;i++){
        //     if(nums[i] >= firstmax){
        //         thirdmax = secondmax;
        //         secondmax = firstmax;
        //         firstmax = nums[i];
        //     }else if(nums[i] <= firstmax && nums[i] >= secondmax){
        //         secondmax = nums[i];
        //     }else if(nums[i] <= secondmax && nums[i] >= thirdmax){
        //         thirdmax = nums[i];
        //     }else if(nums[i] <= firstmin){
        //         firstmin = nums[i];
        //     }else if(nums[i] >= firstmin && nums[i] <= secondmin){
        //         secondmin = nums[i];
        //     }
        // }
        // return Math.max(firstmax*secondmax*thirdmax,firstmax*firstmin*secondmin);
        Arrays.sort(nums);
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]);
    }
}