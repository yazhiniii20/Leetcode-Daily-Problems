class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if(s.length() != goal.length()){
            return false;
        }
        if(s.contains(goal)){
            return true;
        }
        return (s+s).contains(goal);
    }
}