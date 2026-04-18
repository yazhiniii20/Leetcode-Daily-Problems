class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,piles[i]);
        }
        int low = 1;
        int high = max;
        int ans = 0;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(canEatBananas(piles,mid,h)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;        
    }
    static boolean canEatBananas(int[] piles,int target,int hours){
        int rem = 0;
        long timeTaken = 0;
        for(int i=0;i<piles.length;i++){
            timeTaken += piles[i]/target;
            if(piles[i]%target != 0){
              timeTaken += 1;
            }
        }
        return (timeTaken <= hours)?true:false;
    }
}