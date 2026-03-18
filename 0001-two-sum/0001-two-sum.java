class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int num1=0;
        int num2 = 0;
        for(int i=0;i<n;i++){
            int needed = target - nums[i];
            if(!map.containsKey(needed)){
                map.put(nums[i],i);
            }else{
                num1 = map.get(needed);
                num2 = i;
                break;
            }
        }
        return new int[]{num1,num2};
    }
}