class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack();
        for(char ch : num.toCharArray()){
          while(!st.isEmpty() && st.peek() > ch && k>0){
            st.pop();
            k--;
          }
          st.push(ch);
        }
        while(k > 0){
            st.pop();
            k--;
        }
        if (st.isEmpty()) return "0";
        while(!st.isEmpty()){
            ans.append(st.pop());            
        }
        while (ans.length() > 0 && ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
        }
        if(ans.length() == 0) return "0";
        return ans.reverse().toString();
    }
}