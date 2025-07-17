class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(char ch : ransomNote.toCharArray()){
            freq1[ch-'a']++;
        }
        for(char ch : magazine.toCharArray()){
            freq2[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq1[i] != freq2[i] && freq1[i] > freq2[i]){
                return false;
            }
        }
        return true;
    }
}