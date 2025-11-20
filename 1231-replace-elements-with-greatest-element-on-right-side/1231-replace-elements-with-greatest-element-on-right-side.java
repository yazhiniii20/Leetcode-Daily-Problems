class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            arr[i] = greatElement(arr,i+1);
        }
        arr[n-1] = -1;
        return arr;
    }
    private static int greatElement(int[] arr,int idx){
      int max = Integer.MIN_VALUE;
      for(int i=idx;i<arr.length;i++){
        max = Math.max(arr[i],max);
      }
      return max;
    }
}