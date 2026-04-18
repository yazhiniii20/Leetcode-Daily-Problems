class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long) m*k > n){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max,bloomDay[i]);
        }
        int ans = 0;
        while(min <= max){
            int mid = min+(max-min)/2;
            if(possible(bloomDay,mid,m,k)){
                ans = mid;
                max = mid-1;
            }else{
               min = mid+1;
            }
        }
        return ans;
    }
    static boolean possible(int[] arr,int day,int m,int k){
      int count = 0;
      int totalBouquet = 0;
      for(int i=0;i<arr.length;i++){
        if(arr[i] <= day){
            count++;
        }else{
            totalBouquet += count/k;
            count = 0;
        }
      }
      totalBouquet += count / k;
      return totalBouquet >= m;
    }
}