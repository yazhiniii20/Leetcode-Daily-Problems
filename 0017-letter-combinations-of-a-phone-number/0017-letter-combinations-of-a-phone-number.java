class Solution {
    static String[] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.isEmpty()){
            return res;
        }
        possibleCombinations(digits,"",res);
        return res;
    }
    public static void possibleCombinations(String s,String ans, List<String> res){
        if(s.length() == 0){
         res.add(ans);
         return;
        }
        String key = keypad[s.charAt(0)-48];
        for(int i=0;i<key.length();i++){
            possibleCombinations(s.substring(1),ans+key.charAt(i),res);
        }
    }
}