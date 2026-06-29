class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                 q.add(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            int sr = p.row;
            int sc = p.col;
            int steps = p.step;
            mat[sr][sc] = steps;
            check(sr-1,sc,steps,visited,mat,q);
            check(sr,sc+1,steps,visited,mat,q);
            check(sr+1,sc,steps,visited,mat,q);
            check(sr,sc-1,steps,visited,mat,q);
        }
        return mat;
    }
    static void check(int row,int col,int steps,boolean[][] visited,int[][] mat,Queue<Pair> q){
        if(row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || visited[row][col] == true || mat[row][col] == 0){
            return;
        }
        visited[row][col] = true;
        q.offer(new Pair(row,col,steps+1));
    }
    static class Pair{
        int row;
        int col;
        int step;
        public Pair(int row,int col,int step){
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
}