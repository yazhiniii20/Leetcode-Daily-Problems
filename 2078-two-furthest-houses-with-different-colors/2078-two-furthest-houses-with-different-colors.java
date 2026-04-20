class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxLen = 0;
        for(int i=1;i<n;i++){
            if(colors[i] != colors[0]){
                maxLen = Math.max(maxLen,i);
            }
        }
        for(int i=n-1;i>=0;i--){
            if(colors[i] != colors[n-1]){
                maxLen = Math.max(maxLen,(n-1)-i);
            }
        }
        return maxLen;
    }
}