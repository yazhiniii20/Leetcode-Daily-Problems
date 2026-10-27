class Solution {
    public String[] createGrid(int m, int n) {
        char[][] arr = new char[m][n];
        Arrays.fill(arr[0],'.');
        for(int i=1;i<m;i++){
            Arrays.fill(arr[i],'#');
            arr[i][n-1] = '.';
        }
        String[] ans = new String[m];
        for(int i=0;i<m;i++){
            ans[i] = new String(arr[i]);
        }
        return ans;
    }
}