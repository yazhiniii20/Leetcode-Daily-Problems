class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        generateSubsets(nums,0,ans,finalAns);
        return finalAns;
    }
    static void generateSubsets(int[] nums,int index,List<Integer> ans,List<List<Integer>> finalAns){
        finalAns.add(new ArrayList<>(ans));

        for(int i=index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            ans.add(nums[i]);
            generateSubsets(nums,i+1,ans,finalAns);
            ans.remove(ans.size()-1);
        }
    }
}