class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : invocations){
            adj.get(e[0]).add(e[1]);
        }
        boolean[] visited = new boolean[n];
        dfs(k,adj,visited);
        List<Integer> res = new ArrayList<>();
        for(int[] e : invocations){
            int u = e[0];
            int v = e[1];
            if(!visited[u] && visited[v]){
                return allList(n,res);
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                res.add(i);
            }
        }
        return res;
    }
    static void dfs(int k,List<List<Integer>> adj,boolean[] visited){
        visited[k] = true;
        for(int nbr : adj.get(k)){
            if(!visited[nbr]){              
              dfs(nbr,adj,visited);
            }
        }
    }
    static List<Integer> allList(int n,List<Integer> list){
        for(int i=0;i<n;i++){
            list.add(i);
        }
        return list;
    }
}