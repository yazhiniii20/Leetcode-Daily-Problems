class Solution {
    public int minimizedMaximum(int shops, int[] quantities) {
        int n = quantities.length;
        int low = 1;
        int high = 0;
        for(int i=0;i<n;i++){
            high = Math.max(high,quantities[i]);
        }
        int ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(canDistribute(quantities,mid,shops)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    static boolean canDistribute(int[] arr ,int maxPerShop,int shops){
        int total=0;
        for(int i=0;i<arr.length;i++){
            total += arr[i]/maxPerShop;
            if(arr[i]%maxPerShop != 0){
                total += 1;
            }
            if(total > shops){
                return false;
            }
        }
        return (total <= shops);
    }
}