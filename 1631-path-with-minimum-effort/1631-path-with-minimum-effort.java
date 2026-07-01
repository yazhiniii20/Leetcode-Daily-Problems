class Solution {
    static class Pair{
        int row;
        int col;
        int dist;
        public Pair(int row,int col,int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist-b.dist);

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)  dist[i][j] = (int) 1e9;
        }
        dist[0][0] = 0;
        pq.add(new Pair(0,0,0));

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int row = p.row;
            int col = p.col;
            int diff = p.dist;

            if (diff > dist[row][col]) continue;
            if(row == n-1 && col == m-1) return diff;
            
            for(int i=0;i<4;i++){
                int newr = row+dr[i];
                int newc = col+dc[i];
                if(newc >= 0 && newr >= 0 && newc < m && newr < n){
                int effort = Math.max(Math.abs(heights[row][col]-heights[newr][newc]), diff);
                if(effort < dist[newr][newc]){
                    dist[newr][newc] = effort;
                    pq.add(new Pair(newr,newc,effort));
                }
              }
            }
        }
        return 0;
    }
}