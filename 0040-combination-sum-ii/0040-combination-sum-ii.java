class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates,0,ans,finalAns,target);
        return finalAns;
    }
    static void combination(int[] candidates,int index,List<Integer> ans,List<List<Integer>> finalAns,int target){
        if(target == 0){
                finalAns.add(new ArrayList<>(ans));
                return;
        }            
        for(int i=index;i<candidates.length;i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target){
               break;
            }
            ans.add(candidates[i]);
            combination(candidates,i+1,ans,finalAns,target-candidates[i]);
            ans.remove(ans.size()-1);
            //combination(candidates,+1,ans,finalAns,target);
        }
    }
}