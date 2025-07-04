class Solution {
    public char kthCharacter(int k) {
        StringBuilder ans = new StringBuilder();
        ans.append("a");
        while(ans.length() < k){
          ans.append(formString(ans));
        }
        return ans.charAt(k-1); 
    }
    static String formString(StringBuilder s){
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<s.length();i++){
          temp.append((char) (s.charAt(i)+1));
        }
        return temp.toString();
    }
}