class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixsum = 0;
        int seen = 0;
        int count=0;
        for(int i=0;i<n;i++){
            prefixsum += nums[i];
            seen = prefixsum - k;
            if(map.containsKey(seen)){
                count += map.get(seen);
            }
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);     
        }
        return count;
    }
}