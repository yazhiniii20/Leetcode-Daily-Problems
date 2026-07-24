class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n-1;
        int k =0;
        int[] arr = new int[2];
        while(left < right){
            int sum = numbers[left]+numbers[right];
            if(sum == target){
              arr[k] = left+1;
              arr[k+1] = right+1;
              left++;
              right--;
            }
            else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return arr;
    }
}