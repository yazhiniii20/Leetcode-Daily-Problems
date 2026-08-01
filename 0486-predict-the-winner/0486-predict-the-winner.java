class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int ans = f(0,n-1,nums);
        return (ans < 0)? false : true;
    }
    static int f(int left,int right,int[] nums){
        if(left == right) return nums[left];
        int leftPick = nums[left] - f(left+1,right,nums);
        int rightPick = nums[right] - f(left,right-1,nums);
        return Math.max(leftPick,rightPick);
    }
}