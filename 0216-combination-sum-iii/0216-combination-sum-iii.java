class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        generateCombinations(1,ans,finalAns,k,n);
        return finalAns;
    }
    static void generateCombinations(int index,List<Integer> ans,List<List<Integer>> finalAns,int k,int target){
        if(ans.size() == k && target == 0){
            finalAns.add(new ArrayList<>(ans));
            return;
        }
        if(index > 9 || target < 0 || ans.size() > k){
            return;
        }
        ans.add(index);
        generateCombinations(index+1,ans,finalAns,k,target-index);
        ans.remove(ans.size()-1);
        generateCombinations(index+1,ans,finalAns,k,target);      
    }
}