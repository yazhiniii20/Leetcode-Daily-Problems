class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        int[] sortedArr = new int[n];
        for(int i=0;i<n;i++){
            sortedArr[i] = nums[i];
        }
        Arrays.sort(sortedArr);
        int target = 0;
        while(target >=0 && target < n){
            target = Arrays.binarySearch(sortedArr,original);
            if(target <= -1){
                break;
            }
            original *= 2;
        }
        return original;
    }
}