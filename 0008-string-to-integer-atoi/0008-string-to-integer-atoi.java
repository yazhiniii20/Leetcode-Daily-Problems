class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty()){
            return 0;
        }
        long result = 0;
        int sign = 1;
        int i = 0;
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            sign = (s.charAt(0)=='-')?-1:1;
            i++;
        }
        int ans = implementAtoi(s,result,sign,i);
        return ans;
    }
    static int implementAtoi(String s ,long result , int sign,int i){
        if(i >= s.length()){
            return (int)(result*sign);
        }
        if(!Character.isDigit(s.charAt(i))){
            return (int)(result*sign);
        }
        result = (result*10) + s.charAt(i)-'0';
        if(result*sign > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
        }else if(result*sign < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
        }
        return implementAtoi(s,result,sign,i+1);
    }
}