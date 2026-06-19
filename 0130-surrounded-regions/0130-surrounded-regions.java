class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        boolean[][] visited = new boolean[n][m];

        //traverse first row and last row
        for(int j=0;j<m;j++){
            //first row
            if(board[0][j] == 'O' && !visited[0][j]) dfs(0,j,board,visited);
            //last row
            if(board[n-1][j] == 'O' && !visited[n-1][j]) dfs(n-1,j,board,visited);            
        }

        //traverse first column and last column
        for(int i=0;i<n;i++){
            //first column
            if(board[i][0] == 'O' && !visited[i][0]) dfs(i,0,board,visited);
            //last column
            if(board[i][m-1] == 'O' && !visited[i][m-1]) dfs(i,m-1,board,visited);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O' && !visited[i][j]) board[i][j] = 'X';
            }
        }
    }
    static void dfs(int row,int col,char[][] board,boolean[][] visited){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] == true ||board[row][col] == 'X'){
            return;
        }

        visited[row][col] = true;

        dfs(row-1,col,board,visited);
        dfs(row,col+1,board,visited);
        dfs(row+1,col,board,visited);
        dfs(row,col-1,board,visited);
    }
}