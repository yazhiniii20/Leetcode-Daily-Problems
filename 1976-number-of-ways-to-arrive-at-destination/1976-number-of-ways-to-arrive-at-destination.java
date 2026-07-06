class Solution {
    static class Pair{
        int first;
        long second;
        public Pair(int first,long second){
            this.first = first;
            this.second = second;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads){
            adj.get(road[0]).add(new Pair(road[1],road[2]));
            adj.get(road[1]).add(new Pair(road[0],road[2]));
        }
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.second,b.second));
        pq.add(new Pair(0,0));
        int mod = (int)1e9+7;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.first;
            long dis = p.second;
            if(dis > dist[node])  continue;
            for(Pair q : adj.get(node)){
                int nbr = q.first;
                long weight = q.second;
                if(dis+weight < dist[nbr]){
                    dist[nbr] = dis + weight;
                    pq.add(new Pair(nbr,dist[nbr]));
                    ways[nbr] = ways[node];
                }else if(dis + weight == dist[nbr]){
                    ways[nbr] = (ways[nbr] + ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}