class Solution {
    public String largestOddNumber(String num) {
       StringBuilder res = new StringBuilder();
       for(int i=num.length()-1;i>=0;i--){
        char ch = num.charAt(i);
        if((ch -'0')%2 != 0){
            res.append(num.substring(0,i+1));
            break;
        }
       }
       return res.toString();
    }
}