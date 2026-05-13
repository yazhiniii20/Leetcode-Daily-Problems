class Solution {
    public List<String> validStrings(int n) {
        List<String> binary = new ArrayList<>();
        generateBinaryStrings(binary,"",1,n);
        return binary;
    }
    static void generateBinaryStrings(List<String> binary,String res,int last,int n){
         if(res.length() == n){
           binary.add(res);
           return;
       }
      generateBinaryStrings(binary,res+'1',1,n);
      if(last == 1){
     generateBinaryStrings(binary,res+'0',0,n);
      }
    }
}