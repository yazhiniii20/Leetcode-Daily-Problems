class Solution {
    public int[] findOrder(int V, int[][] edges) {
        int m = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[1]).add(e[0]);
        }
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int nbr : adj.get(i)){
                indegree[nbr]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0) q.add(i);
        }
        int[] topo = new int[V];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[i++] = node;
            for(int nbr : adj.get(node)){
              indegree[nbr]--;
              if(indegree[nbr] == 0) q.add(nbr);
            }
        }
        if(i != V)  return new int[0];
        return topo;
    }
}