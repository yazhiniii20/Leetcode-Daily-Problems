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
        if(node == parent[node]) return node;
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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int countExtras = 0;
        for(int[] con : connections){
            int u = con[0];
            int v = con[1];
            if(ds.findParent(u) == ds.findParent(v)){
                countExtras++;
            }else{
                ds.unionBySize(u,v);
            }
        }
        int countComponents = 0;
        for(int i=0;i<n;i++){
            if(ds.parent[i] == i){
                countComponents++;
            }
        }
        int ans = countComponents-1;
        return (countExtras >= ans)? ans : -1;
    }
}