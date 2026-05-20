class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        combination(candidates,0,ans,finalAns,target);
        return finalAns;
    }
    static void combination(int[] candidates,int index,List<Integer> ans,List<List<Integer>> finalAns,int target){
        if(index == candidates.length){
           if(target == 0){
            finalAns.add(new ArrayList<>(ans));
        }
         return;          
        }
        if(candidates[index] <= target){
        ans.add(candidates[index]);
        combination(candidates,index,ans,finalAns,target-candidates[index]);
        ans.remove(ans.size()-1);
        }
        combination(candidates,index+1,ans,finalAns,target);
    }
}