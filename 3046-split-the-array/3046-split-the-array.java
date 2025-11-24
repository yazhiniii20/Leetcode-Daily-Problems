class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
        }
        int[] freq = new int[max+1];
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        for(int i=0;i<=max;i++){
            if(freq[i] > 2){
                return false;
            }
        }
        return true;
    }
}