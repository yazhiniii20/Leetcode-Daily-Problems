class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int element = 0;
        for(int i=0;i<n;i++){
            if(count == 0){
             element = nums[i];
             count = 1;
            }else if(count > 0){
                if(element == nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
        }
        count=0;
        for(int i=0;i<n;i++){
            if(element == nums[i]){
                count++;
            }
        }
        return (count>n/2)?element:-1;
    }
}