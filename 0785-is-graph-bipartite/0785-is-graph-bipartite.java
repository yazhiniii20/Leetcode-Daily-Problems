class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(dfs(i,0,graph,color) == false) return false; 
            }
        }
        return true;
    }
    static boolean dfs(int node,int c , int[][] graph,int[] color){
        int n = graph.length;
        color[node] = c;
        for(int i=0;i<graph[node].length;i++){
            int nbr = graph[node][i];
             if(color[nbr] == -1){
                if(dfs(nbr,1-c,graph,color) == false) return false;
              }else if(color[nbr] == color[node]){
                return false;
              }
           }
        return true; 
    }
}