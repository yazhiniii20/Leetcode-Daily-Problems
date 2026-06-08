class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
              count++;
              visited[i] = true;
              Queue<Integer> q = new LinkedList<>();
              q.offer(i);
              while(!q.isEmpty()){
                int node = q.poll();
                for(int j=0;j<isConnected[node].length;j++){
                    if(!visited[j] && isConnected[node][j] == 1){
                        visited[j] = true;
                        q.offer(j);
                    }
                }
              }
            }
        }
        return count;
    }
}