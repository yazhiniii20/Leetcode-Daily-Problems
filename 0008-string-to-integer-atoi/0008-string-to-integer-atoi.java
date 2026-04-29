class Solution {
    public int myAtoi(String s) {
        long result = 0;
        s = s.trim();
        if(s.isEmpty()){
            return 0;
        }
        int n = s.length();
        int i = 0;
        int sign = 1;
        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            sign = (s.charAt(i) == '-')?-1:1;
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            result = (result*10)+s.charAt(i)-'0';
            if(result*sign > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(result*sign < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)result*sign;
    }
}