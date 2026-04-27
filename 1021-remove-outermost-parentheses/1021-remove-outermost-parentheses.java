class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '('){
              if(!st.empty()){
                res.append(ch);
              }
              st.push(ch);

            }else{
               st.pop();
               if(!st.empty()){
                res.append(ch);
               }
            }
        }
        return res.toString();
    }
}