class Solution {
    public void rotate(int[][] matrix) {
       int m = matrix.length;
       int n = matrix[0].length;
       transpose(matrix,m,n);
       reverse(matrix,n);
    }
    static void transpose(int[][] mat,int m,int n){
        for(int i=0;i<m-1;i++){
            for(int j=i+1;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    static void reverse(int[][] mat, int n) {
            for (int i = 0; i < n; i++) {
              int left = 0, right = n - 1;
             while (left < right) {
               int temp = mat[i][left];
               mat[i][left] = mat[i][right];
               mat[i][right] = temp;
               left++;
               right--;
        }
      }
    }
}