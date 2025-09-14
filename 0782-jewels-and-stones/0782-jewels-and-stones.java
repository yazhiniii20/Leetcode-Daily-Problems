class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int m = jewels.length();
        int n = stones.length();
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(stones.charAt(j) == jewels.charAt(i)){
                    count++;
                }
            }
        }
        return count;
    }
}