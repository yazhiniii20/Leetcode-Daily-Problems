class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans;
        for(int i=1;i<=numRows;i++){
            ans = new ArrayList<>();
            findNcr(ans,i);
            res.add(ans);
        }
        return res;
    }
    static void findNcr(List<Integer> ans,int row){
        int a = 1;
        ans.add(a);
        for(int col=1;col<row;col++){
            a = a*(row-col);
            a = a/(col);
            ans.add(a);
        }
    }
}