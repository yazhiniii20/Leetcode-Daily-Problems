class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1;j<n;j++){
               int third = -(nums[i]+nums[j]);
               if(hashset.contains(third)){
                List<Integer> arr = new ArrayList<>();
                arr.add(nums[i]);
                arr.add(nums[j]);
                arr.add(third);
                Collections.sort(arr);
                st.add(arr);
               }
               hashset.add(nums[j]);
            }
        }
        return new ArrayList<>(st);
    }
}