class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            int row = findMaxElement(mat,m,n,mid);
            int left = (mid-1 >= 0) ? mat[row][mid-1] : -1;
            int right = (mid+1 < n) ? mat[row][mid+1] : -1;
            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row,mid};
            }else if(mat[row][mid] < left){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    static int findMaxElement(int[][] mat,int m,int n,int col){
        int max = 0;
        int rowIndex = -1;
        for(int row=0;row<m;row++){
            if(max < mat[row][col]){
               max = mat[row][col];
               rowIndex = row;
            }
        }
        return rowIndex;
    }
}