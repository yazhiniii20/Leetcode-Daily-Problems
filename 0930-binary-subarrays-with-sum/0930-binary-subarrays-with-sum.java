class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            prefixSum += nums[i];
            int seen = prefixSum-goal;
            if(map.containsKey(seen)){
                 count += map.get(seen);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}