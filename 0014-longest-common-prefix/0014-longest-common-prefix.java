class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
           prefix = longestPrefix(prefix,strs[i]);
        }
        return prefix;
    }
    static String longestPrefix(String prefix,String str){
        int i=0;
        int j=0;
        while(i < prefix.length() && j < str.length()){
            if(prefix.charAt(i) == str.charAt(j)){
                i++;
                j++;
            }else{
              break;
            }
        }
        return prefix.substring(0,i);
    }
}