class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> rev = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            rev.add(new ArrayList<>());
        }
        int[] indegree = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int nbr : graph[i]){
                rev.get(nbr).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        List<Integer> safe = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            safe.add(node);
            for(int nbr : rev.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0)  q.add(nbr);
            }
        }
        Collections.sort(safe);
        return safe;
    }
}