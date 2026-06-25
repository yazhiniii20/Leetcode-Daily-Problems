class Solution {
    public int longestStrChain(String[] words) {
      Arrays.sort(words, (a,b)->a.length()-b.length());
      int n = words.length;
      int ans = 1;
      int[] dp = new int[n];
      Arrays.fill(dp,1);
      for(int i = 0; i < n; i++){
        for(int j = 0; j < i; j++){
           if(isPredecessor(words[i],words[j]) && dp[j]+1 > dp[i]){
             dp[i] = dp[j]+1;
           }
        }
        ans = Math.max(ans,dp[i]);
      }
      return ans;
    }
    static boolean isPredecessor(String s1,String s2){
        if(s1.length() != s2.length()+1) return false;
        int i = 0;
        int j = 0;
        while(i < s1.length()){
            if(j < s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return (i == s1.length() && j == s2.length());
    }
}