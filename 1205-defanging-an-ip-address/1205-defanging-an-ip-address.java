class Solution {
    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        int n = address.length();
        for(int i=0;i<n;i++){
            if(address.charAt(i) == '.'){
                str.append("[.]");
            }else{
                str.append(address.charAt(i));
            }
        }
        return str.toString();
    }
}