class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> finalAns = new ArrayList<>();
       List<String> ans = new ArrayList<>();
       partitioning(0,s,ans,finalAns);
       return finalAns;
    }
    static void partitioning(int index,String s,List<String> ans,List<List<String>> finalAns){
        if(index == s.length()){
            finalAns.add(new ArrayList<>(ans));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                ans.add(s.substring(index,i+1));
                partitioning(i+1,s,ans,finalAns);
                ans.remove(ans.size()-1);
            }
        }
    }
    static boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
 }