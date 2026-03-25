class Solution {
    public int[] rearrangeArray(int[] nums) {
       int n = nums.length;
       int[] modifiedArr = new int[n];
       int[] positive = new int[n/2];
       int[] negative = new int[n/2];
       int j = 0;
       for(int i=0;i<n;i++){
        if(nums[i] > 0){
           positive[j++] = nums[i];
        }
       }
       j=0;
       for(int i=0;i<n;i++){
        if(nums[i] < 0){
           negative[j++] = nums[i];
        }
       }
       j=0;
       int k = 0;
       for(int i=0;i<n;i++){
        if(i%2 == 0){
        modifiedArr[i] = positive[j];
        j++;
        }else{
         modifiedArr[i] = negative[k];
         k++;
        }
       }
       return modifiedArr;

    }
}