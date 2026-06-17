class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String reversedString = reverse(s);
        int lps = lcs(s,reversedString);
        return n-lps;
    }
    static int lcs(String s1,String s2){
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++) dp[i][0] = 0;
        for(int i=0;i<=n;i++) dp[0][i] = 0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
    static String reverse(String s){
        StringBuilder str = new StringBuilder(s);
        return str.reverse().toString();
    }
}