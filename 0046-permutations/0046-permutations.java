class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalAns = new ArrayList<>();
        backtrack(nums,new ArrayList<>(),finalAns);
        return finalAns;
    }
    static void backtrack(int[] nums,List<Integer> temp,List<List<Integer>> finalAns){
        if(temp.size() == nums.length){
          finalAns.add(new ArrayList<>(temp));
        }else{
            for(int i=0;i<nums.length;i++){
                if(temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backtrack(nums,temp,finalAns);
                temp.remove(temp.size()-1);
            }
        }
    }
}