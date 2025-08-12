class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i=0;
        int j=n-1;
        StringBuilder str = new StringBuilder();
        boolean res = true;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                res = isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
                break;
            }
            i++;
            j--;
        }
        return res;
    }
    static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}