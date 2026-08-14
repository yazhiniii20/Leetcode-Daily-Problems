class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        // HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int[] freq = new int[26];
        int maxLen = 0;
        for(int right=0;right<n;right++){
            char ch = s.charAt(right);
            freq[ch-'a']++;
            while(freq[ch-'a'] > 2){
                char ch1 = s.charAt(left);
                freq[ch1-'a']--;
                left++;
            }
            maxLen = Math.max(maxLen,(right-left)+1);
        }
        return maxLen;
    }
}