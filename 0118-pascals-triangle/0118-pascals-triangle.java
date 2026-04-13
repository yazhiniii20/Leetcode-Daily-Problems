class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            res.add(findNcr(i));
        }
        return res;
    }
    static  List<Integer> findNcr(int row){
        List<Integer> ans = new ArrayList<>();
        int a = 1;
        ans.add(a);
        for(int col=1;col<row;col++){
            a = a*(row-col);
            a = a/(col);
            ans.add(a);
        }
        return ans;
    }
}