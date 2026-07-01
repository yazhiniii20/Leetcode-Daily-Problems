class Solution {
    static class Pair{
        int first;
        int second;
        int dist;
        public Pair(int first,int second,int dist){
            this.first = first;
            this.second = second;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();
        return bfs(0,0,visited,q,grid);  
    }             
    static int bfs(int row,int col,boolean[][] visited,Queue<Pair> q,int[][] grid){
        int n = grid.length;
        q.offer(new Pair(row,col,1));
        visited[row][col] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int sr = p.first;
            int sc = p.second;
            int dist = p.dist;
            if(sr == n-1 && sc == n-1) return dist;
            check(sr-1,sc,dist,visited,q,grid);
            check(sr,sc+1,dist,visited,q,grid);
            check(sr+1,sc,dist,visited,q,grid);
            check(sr,sc-1,dist,visited,q,grid);
            check(sr-1,sc-1,dist,visited,q,grid);
            check(sr+1,sc+1,dist,visited,q,grid);
            check(sr-1,sc+1,dist,visited,q,grid);
            check(sr+1,sc-1,dist,visited,q,grid);            
        }
        return -1;
    }
    static boolean check(int row,int col,int dist,boolean[][] visited,Queue<Pair> q,int[][] grid){
        int n = grid.length;
        if(row < 0 || row >= n || col < 0 || col >= n || grid[row][col] == 1 || visited[row][col] == true){
            return false;
        }
        q.offer(new Pair(row,col,dist+1));
        visited[row][col] = true;
        return true;
    }
}