class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int n = nums.length;
        int[] positions = new int[2];
        for(int i=0;i<n;i++){
            if(nums[i] == target && first == -1){
                first = i;
                last = i;
            }
            else if(nums[i] == target && first != -1){
                last = i;
            }
        }
        positions[0] = first;
        positions[1] = last;
        return positions;
    }
}