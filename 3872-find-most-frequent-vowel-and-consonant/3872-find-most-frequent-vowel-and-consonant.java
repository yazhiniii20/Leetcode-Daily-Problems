class Solution {
    public int maxFreqSum(String s) {
       int n = s.length();
       int[] alpha = new int[26];
       for(char c : s.toCharArray()){
         alpha[c-'a']++;
       }
       int vowelmax=0;
       int consmax=0;
       for(int i=0;i<n;i++){
         if(isVowel(s.charAt(i))){
            vowelmax = Math.max(vowelmax,alpha[s.charAt(i)-'a']);
         }else{
            consmax = Math.max(consmax,alpha[s.charAt(i)-'a']);
         }
       }
       return vowelmax+consmax;
    }
    public static boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}