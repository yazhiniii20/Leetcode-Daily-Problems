class Solution {
    static class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    static class Tuple{
        int stops;
        int node;
        int dist;
        public Tuple(int stops,int node,int dist){
            this.stops = stops;
            this.node = node;
            this.dist = dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        int[] dist = new int[n];

        for(int i=0;i<n;i++) dist[i] = (int)1e9;

        dist[src] = 0;

        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(0,src,0));

        while(!q.isEmpty()){
            Tuple t = q.poll();
            int stops = t.stops;
            int node = t.node;
            int cost = t.dist;
            if(stops > k) continue;
            for(Pair p : adj.get(node)){
                int nbr = p.first;
                int path = p.second;
                if(cost+path < dist[nbr]){
                    dist[nbr] = cost+path;
                    q.offer(new Tuple(stops+1,nbr,dist[nbr]));
                }
            }
        }
        return (dist[dst] == 1e9)?-1:dist[dst];
    }
}