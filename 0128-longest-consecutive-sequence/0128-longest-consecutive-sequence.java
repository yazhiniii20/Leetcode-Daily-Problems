class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int longest = 1;
        int count = 0;
        for(int num : set){
          if(!set.contains(num-1)){
            count = 1;
            int x = num;
            while(set.contains(x+1)){
                count++;
                x++;
            }
            longest = Math.max(longest,count);
          }
        }
        return longest;
    }
}