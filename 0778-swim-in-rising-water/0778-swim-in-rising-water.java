class DisjointSet{
    int[] parent;
    int[] size;
    public DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }
    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v) return;
        if(ulp_u < ulp_v){
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
       }
    }
}
class Solution {
    static boolean isValid(int r,int c,int n){
        if(r >= 0 && c >= 0 && r < n && c < n) return true;
        return false;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        boolean[][] visited = new boolean[n][n];
        int[][] position = new int[n*n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               position[grid[i][j]][0] = i;
               position[grid[i][j]][1] = j;
            }
        }
        int time = 0;
        for(time=0;time<n*n;time++){
            int row = position[time][0];
            int col = position[time][1];

            visited[row][col] = true;

            int[] dr = {-1,0,1,0};
            int[] dc = {0,1,0,-1};

            for(int index=0;index<4;index++){
                int newr = row + dr[index];
                int newc = col + dc[index];
                if(isValid(newr,newc,n) && visited[newr][newc]){
                    int node = (row*n)+col;
                    int adjNode = (newr*n)+newc;
                    ds.unionBySize(node,adjNode);
                }
            }
            if(ds.findParent(0) == ds.findParent(n*n-1)) return time;
        }
        return -1;
    }
}