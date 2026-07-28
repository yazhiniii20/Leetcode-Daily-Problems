class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;
        String first = s.substring(0,n/2);
        //String second = s.substring(n/2,n);
        String sortedString = sort(first);
        String reversed = reverse(sortedString);
        if(n%2 != 0){
            String ch = s.substring(n/2,(n/2)+1);
            sortedString = sortedString.concat(ch);
        }
        String res = sortedString.concat(reversed);
        return res;
    }
    static String sort(String s){
        StringBuilder res = new StringBuilder();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        for(char c : ch){
            res.append(c);
        }
        return res.toString();
    }
    static String reverse(String s){
        StringBuilder res = new StringBuilder(s);
        return res.reverse().toString();
    }
}