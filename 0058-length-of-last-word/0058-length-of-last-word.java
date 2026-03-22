class Solution {
    public int lengthOfLastWord(String s) {
        boolean chars = false;
        int len=0;
        for(int i = s.length()-1; i>=0;i--){
            if(Character.isLetter(s.charAt(i))){
                chars = true;
                len++;
            }
            else{
                if(chars == true)
                  return len;
            }
        }
        return len;
    }
   
}