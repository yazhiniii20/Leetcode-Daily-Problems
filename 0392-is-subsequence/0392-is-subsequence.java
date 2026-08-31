class Solution {
    public boolean isSubsequence(String s, String t) {
       int n1 = s.length();
       int n2 = t.length();
       int cnt=0;
       int i=0;
       int j=0;
       while(i<n1 && j<n2){
        if(s.charAt(i) != t.charAt(j)){
            j++;
        }
        else if(s.charAt(i) == t.charAt(j)){
            i++;
            j++;
            cnt++;
        }
       }
       return (cnt==n1);
    }
}