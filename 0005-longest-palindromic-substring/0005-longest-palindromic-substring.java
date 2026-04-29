class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        if(s == null || s.length() <= 1){
            return s;
        }
        int n = s.length();
        for(int i=0;i<n;i++){
            String odd = expand(s,i,i);
            String even = expand(s,i,i+1);
            if(odd.length() > result.length()){
                result = odd;
            }
            if(even.length() > result.length()){
                result = even;
            }
        }
        return result;
    }
    static String expand(String s,int low,int high){
        while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
            low--;
            high++;
        }
        return s.substring(low+1,high);
    }
}