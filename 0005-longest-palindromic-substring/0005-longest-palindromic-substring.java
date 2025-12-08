class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0 || n==1){
            return s;
        }
         String str="";
        for(int i=1;i<n;i++){
            int l=i;
            int h=i;
            while(s.charAt(l) == s.charAt(h)){
                l--;
                h++;
                if(l < 0 || h > n-1){
                    break;
                }
            }
            String p = s.substring(l+1,h);
            if(p.length() > str.length()){
                str = p;
            }
            l = i-1;
            h=i;
            while(s.charAt(l) == s.charAt(h)){
                l--;
                h++;
                if(l < 0 || h > n-1){
                    break;
                }
            }
             p = s.substring(l+1,h);
            if(p.length() > str.length()){
                str = p;
            }

        }
        return str;
    }
}