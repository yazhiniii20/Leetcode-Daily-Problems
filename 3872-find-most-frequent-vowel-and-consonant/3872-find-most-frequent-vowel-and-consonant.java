class Solution {
    public int maxFreqSum(String s) {
       int n = s.length();
       HashMap<Character,Integer> map = new HashMap<>();
       for(char c : s.toCharArray()){
        map.put(c,map.getOrDefault(c,0)+1);
       }
       int vowelmax = 0;
       int consonantmax = 0;
       for(char c : map.keySet()){
        if(isVowel(c)){
            vowelmax = Math.max(vowelmax,map.get(c));
        }else{
            consonantmax = Math.max(consonantmax,map.get(c));
        }
       }
       return vowelmax + consonantmax;
    }
    public static boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}