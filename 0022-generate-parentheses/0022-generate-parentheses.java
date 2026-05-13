class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        possibleParantheses(0,0,"",res,n);
        return res;
    }
    static void possibleParantheses(int open,int close,String ans,List<String> res,int n){
        if(ans.length() == 2*n){
            res.add(ans);
            return;
        }
        if(open < n){
        possibleParantheses(open+1,close,ans+'(',res,n);
        }
        if(close < open){
            possibleParantheses(open,close+1,ans+')',res,n);
        }
    }
}