class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int Countzero = 0;
        int Countone = 0;
        int Counttwo = 0;
        for(int i=0;i<n;i++){
          if(nums[i] == 0){
            Countzero++;
          }else if(nums[i] == 1){
            Countone++;
          }else if(nums[i] == 2){
            Counttwo++;
          }
        }
        int i=0;
        while(Countzero > 0){
            nums[i++] = 0;
            Countzero--;
        }
        while(Countone > 0){
            nums[i++] = 1;
            Countone--;
        }
        while(Counttwo > 0){
            nums[i++] = 2;
            Counttwo--;
        }
    }
}