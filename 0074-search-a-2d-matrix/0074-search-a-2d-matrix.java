class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean ans = false;
        for(int i = 0;i<m;i++){
            ans  = findElement(matrix[i],n,target);
            if(ans == true){
                return true;
            }
        }
        return false;
    }
    static boolean findElement(int[] matrix,int n,int target){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(matrix[mid] == target){
                return true;
            }else if(matrix[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
    }
}