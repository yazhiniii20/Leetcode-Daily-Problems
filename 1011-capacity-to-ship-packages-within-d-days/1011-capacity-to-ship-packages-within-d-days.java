class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = 0;
        int high = 0;
        for(int i=0;i<n;i++){
         low = Math.max(low,weights[i]);
         high += weights[i];
        }
        int ans=0;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(canShipPackages(weights,mid,days)){
              ans = mid;
              high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    static boolean canShipPackages(int[] weights,int capacity,int days){
        int load = 0;
        int d = 1;
        for(int i=0;i<weights.length;i++){
           load += weights[i];
           if(load > capacity){
            load = weights[i];
            d++;
           }
        }
        return (d <= days);
    }
}