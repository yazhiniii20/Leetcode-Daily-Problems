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
    static boolean isValid(int row,int col,int n){
        if(row >= 0 && col >= 0 && row < n && col < n) return true;
        return false;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);

        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0) continue;
                int[] dr = {-1,0,1,0};
                int[] dc = {0,1,0,-1};
                for(int i = 0; i < 4; i++){
                    int newr = row + dr[i];
                    int newc = col + dc[i];
                    if(isValid(newr,newc,n) && grid[newr][newc] == 1){
                       int nodeno = (row*n) + col;
                       int adjNodeno = (newr*n) + newc;
                       ds.unionBySize(nodeno,adjNodeno);
                    }
                }
            }
        }
        
        int max = 0;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1) continue;
                int[] dr = {-1,0,1,0};
                int[] dc = {0,1,0,-1};
                HashSet<Integer> components = new HashSet<>();
                for(int i = 0; i < 4; i++){
                    int newr = row + dr[i];
                    int newc = col + dc[i];
                    if(isValid(newr,newc,n) && grid[newr][newc] == 1){
                       int nodeno = (row*n) + col;
                       int adjNodeno = (newr*n) + newc;
                       components.add(ds.findParent(adjNodeno));
                    }
                }
                int sizeTotal = 0;
                for(Integer c : components){
                    sizeTotal += ds.size[c];
                }
                max = Math.max(max,sizeTotal+1);
            }
        }
        //if it contains all 1's
        for(int i=0;i<n*n;i++){
            max = Math.max(max,ds.size[ds.findParent(i)]);
        }
        return max;
    }
}