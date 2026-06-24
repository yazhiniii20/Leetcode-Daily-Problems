class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(bfs(i,graph,color) == false) return false; 
            }
        }
        return true;
    }
    static boolean bfs(int start,int[][] graph,int[] color){
        int n = graph.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
           for(int i=0;i<graph[node].length;i++){
              int nbr = graph[node][i];
              if(color[nbr] == -1){
                color[nbr] = 1 - color[node];
                q.offer(nbr);
              }else if(color[nbr] == color[node]){
                return false;
              }
           }
        }
        return true; 
    }
}