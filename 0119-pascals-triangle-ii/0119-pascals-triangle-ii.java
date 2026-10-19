class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int row = rowIndex+1;
        long a = 1;
        ans.add((int)a);
        for(int col=1;col<row;col++){
           a = a*(row-col);
           a = a/col;
           ans.add((int)a);
        }
        return ans;
    }
}