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
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int[] stone : stones){
            maxRow = Math.max(maxRow,stone[0]);
            maxCol = Math.max(maxCol,stone[1]);
        }
        int n = maxRow + maxCol + 2;
        DisjointSet ds = new DisjointSet(n);
        HashSet<Integer> stoneSet = new HashSet<>();
        for(int[] stone : stones){
           int nodeRow = stone[0];
           int nodeCol = stone[1]+maxRow+1;
           stoneSet.add(nodeRow);
           stoneSet.add(nodeCol);
           ds.unionBySize(nodeRow,nodeCol);
        }
        int countComponents = 0;
        for(int s : stoneSet){
            if(ds.findParent(s) == s){
               countComponents++;
            }
        }
        return (stones.length - countComponents);
    }
}