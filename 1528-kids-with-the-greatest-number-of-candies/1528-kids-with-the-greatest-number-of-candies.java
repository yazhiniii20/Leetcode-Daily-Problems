class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int max=0;
        for(int i=0;i<n;i++){
            max = Math.max(max,candies[i]);
        }
        List<Boolean> greater = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(candies[i]+extraCandies >= max){
                greater.add(true);
            }else{
                greater.add(false);
            }
        }
        return greater;
    }
}