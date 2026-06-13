class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str = new StringBuilder();
        int sum = 0;
        for(String word : words){
            sum = 0;
            for(char ch : word.toCharArray()){
                   sum += weights[ch-'a'];
            }
            int mod = sum%26;
            char c = (char)('z'-mod);
            str.append(c);
        }
        return str.toString();
    }
}