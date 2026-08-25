class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        int ans = k;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        for(int i=0;i<n;i++){
            if(!set.contains(ans)) return ans;
            ans += k;
        }
        return ans;
    }
}