class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums,0,n-1);
    }
    static int mergeSort(int[] nums,int low,int high){
        int count = 0;
        if(low >= high){
            return count;
        }
        int mid = low+(high-low)/2;
        count += mergeSort(nums,low,mid);
        count += mergeSort(nums,mid+1,high);
        count += countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return count;
    }
    static int countPairs(int[] nums,int low,int mid,int high){
        int right = mid+1;
        int count = 0;
        for(int i=low;i<=mid;i++){
            while(right <= high && nums[i] > 2L*nums[right]){
                right++;
            }
            count += (right - (mid+1));
        }
        return count;
    }
    static void merge(int[] nums,int low,int mid,int high){
        int left = low;
        int right = mid+1;
        int[] temp = new int[high-low+1];
        int k=0;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[k++] = nums[left];
                left++;
            }else{
                temp[k++] = nums[right];
                right++;
            }
        }
        while(left <= mid){
            temp[k++] = nums[left];
            left++;
        }
        while(right <= high){
            temp[k++] = nums[right];
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i] = temp[i-low];
        }
    }
}