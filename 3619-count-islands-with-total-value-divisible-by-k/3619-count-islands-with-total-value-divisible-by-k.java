class Solution {
    static long sum = 0;
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(grid[i][j] > 0){
                    sum=0;
                    dfs(grid,i,j);
                    if(sum%k == 0) ans++;
               }
           }
        }
        return ans;
    }
    static void dfs(int[][] grid,int i,int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        sum += grid[i][j];
        grid[i][j] = 0;
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
}