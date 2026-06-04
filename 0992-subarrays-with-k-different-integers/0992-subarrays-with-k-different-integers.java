class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return function(nums,k) - function(nums,k-1);        
    }
    static int function(int[] nums,int k){
        int n = nums.length;
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        for(int right=0;right<n;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size() > k){
                map.put(nums[left],map.getOrDefault(nums[left],0)-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count += (right-left)+1;
        }
        return count;
    }
}