class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[n-1];
        boolean[] arr = new boolean[max+1];
        for(int i=0;i<n;i++){
            arr[nums[i]] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(arr[i] == false){
                ans.add(i);
            }
        }
        return ans;
    }
}