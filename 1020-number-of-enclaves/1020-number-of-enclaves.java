class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        //traverse rows
        for(int i=0;i<m;i++){
            //first row
            if(grid[0][i] == 1 && !visited[0][i]){
                dfs(0,i,grid,visited);
            }
            //last row
            if(grid[n-1][i] == 1 && !visited[n-1][i]){
                dfs(n-1,i,grid,visited);
            }
        }
        //traverse columns
        for(int i=0;i<n;i++){
            //first col
            if(grid[i][0] == 1 && !visited[i][0]){
                dfs(i,0,grid,visited);
            }
            //last col
            if(grid[i][m-1] == 1 && !visited[i][m-1]){
                dfs(i,m-1,grid,visited);
            }
        }
        int countOnes = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    countOnes++;
                }
            }
        }
        return countOnes;
    }
    static void dfs(int row,int col,int[][] grid,boolean[][] visited){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || visited[row][col] == true){
            return;
        }
        visited[row][col] = true;
        dfs(row-1,col,grid,visited);
        dfs(row,col+1,grid,visited);
        dfs(row,col-1,grid,visited);
        dfs(row+1,col,grid,visited);
    }
}