class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split("\\s+");
        int i = 0;
        int j = str.length-1;
        while(i < j){
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        StringBuilder res = new StringBuilder();
        for(i=0;i<str.length;i++){
            res.append(str[i]);
            if(i != str.length-1){
                res.append(" ");
            }
        }
        return new String(res);
    }
}