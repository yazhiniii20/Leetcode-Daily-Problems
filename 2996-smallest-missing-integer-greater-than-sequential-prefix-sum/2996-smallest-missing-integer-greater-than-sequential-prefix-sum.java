class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int sum = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i] == nums[i-1]+1){                
               sum += nums[i];
            }else{
                break;
            }
        }
         for(int i=0;i<n;i++){
             if(set.contains(sum)) sum++;
        }
        return sum;
    }
}