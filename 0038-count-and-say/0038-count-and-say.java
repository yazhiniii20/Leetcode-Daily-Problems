class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String ans = "1";
        for(int i=2;i<=n;i++){
            ans = compress(ans);
        }
        return ans;
    }
    static String compress(String compressed){
       String ans = "";
       int count = 1;
       for(int i=1;i<compressed.length();i++){
        char ch = compressed.charAt(i);
        if(compressed.charAt(i) == compressed.charAt(i-1)){
            count++;
        }else{
            ans += count;
            ans += compressed.charAt(i-1);
            count = 1;
        }
       }
       ans += count;
       ans += compressed.charAt(compressed.length() - 1);
       return ans;
    }
}