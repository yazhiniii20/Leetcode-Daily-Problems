class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1=0;
        int count2=0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;
        int minTimes = (int)Math.floor(n/3);
        for(int i=0;i<n;i++){
            if(count1 == 0 && nums[i] != element2){
                count1 = 1;
                element1 = nums[i];
            }else if(count2 == 0 && nums[i] != element1){
                count2=1;
                element2 = nums[i];
            }else if(nums[i] == element1){
                count1++;
            }else if(nums[i] == element2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(element1 == nums[i]){
                count1++;
            }else if(element2 == nums[i]){
                count2++;
            }
        }
        if(count1 > minTimes){res.add(element1);}
        if(count2 > minTimes){res.add(element2);}
        return res;
    }
}