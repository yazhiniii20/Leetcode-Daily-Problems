class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] txt = text.split(" ");
        int n = txt.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(canBeTyped(txt[i],brokenLetters) == true){
              count++;
            }
        }
        return count;
    }
    private static boolean canBeTyped(String txt,String brokenLetters){
      HashSet<Character> set = new HashSet<>();
      for(char ch : txt.toCharArray()){
        set.add(ch);
      }
      for(char ch:brokenLetters.toCharArray()){
         if(set.contains(ch)){
            return false;
         }
      }
      return true;
    }
}