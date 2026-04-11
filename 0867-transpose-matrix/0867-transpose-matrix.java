class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        if(m != n){
         int[][] newmat = new int[m][n];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                newmat[j][i] = matrix[i][j];
            }
         }
         return newmat;
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }
}