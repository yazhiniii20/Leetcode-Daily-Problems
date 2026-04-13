class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans;
        for(int i=1;i<=numRows;i++){
            ans = new ArrayList<>();
            for(int j=1;j<=i;j++){
                ans.add(findNcr(ans,i-1,j-1));
            }
            res.add(ans);
        }
        return res;
    }
    static int findNcr(List<Integer> ans,int row,int col){
        int a = 1;
        for(int i=0;i<col;i++){
            a = a*(row-i);
            a = a/(i+1);
        }
        return a;
    }
}