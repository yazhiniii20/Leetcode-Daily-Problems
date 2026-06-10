class Solution {
    public boolean canFinish(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
           adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,-1,adj,visited,path)) return false;
            }
        }
        return true;     
    }
    static boolean dfs(int src,int parent,List<List<Integer>> adj,boolean[] visited,boolean[] path){
        visited[src] = true;
        path[src] = true;
        for(int nbr : adj.get(src)){
            if(!visited[nbr]){
            if(dfs(nbr,src,adj,visited,path)){
                return true;
            }
          }else if(path[nbr]){
            return true;
          }
        }
        path[src] = false;
        return false;
    }    
}