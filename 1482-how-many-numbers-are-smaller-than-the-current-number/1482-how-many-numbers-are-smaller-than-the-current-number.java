class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
         int[] sortedarr = nums.clone();
         Arrays.sort(sortedarr);
         HashMap<Integer,Integer> map = new HashMap<>();
         for(int i=0;i<n;i++){
           map.putIfAbsent(sortedarr[i],i);
         }
         int[] res = new int[n];
         for(int i=0;i<n;i++){
            res[i] = map.get(nums[i]);
         }
         return res;
    }
}